package com.zhl.pyg.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhanghualei
 * @Classname RedisLock
 * @Date 2021/3/13 17:43
 */
@Component
public class RedisLock implements Rlock {

    private DefaultRedisScript<Long> redisScriptLock;
    private DefaultRedisScript<Long> redisScriptUnLock;
    public static final String LOCK_LUA_SCRIPT = "-- 若锁不存在：则新增锁，并设置锁重入计数为1、设置锁过期时间\n" +
            "if (redis.call('exists', KEYS[1]) == 0) then\n" +
            "    redis.call('hset', KEYS[1], ARGV[2], 1);\n" +
            "    redis.call('pexpire', KEYS[1], ARGV[1]);\n" +
            "    return nil;\n" +
            "end;\n" +
            " \n" +
            "-- 若锁存在，且唯一标识也匹配：则表明当前加锁请求为锁重入请求，故锁重入计数+1，并再次设置锁过期时间\n" +
            "if (redis.call('hexists', KEYS[1], ARGV[2]) == 1) then\n" +
            "    redis.call('hincrby', KEYS[1], ARGV[2], 1);\n" +
            "    redis.call('pexpire', KEYS[1], ARGV[1]);\n" +
            "    return nil;\n" +
            "end;\n" +
            " \n" +
            "-- 若锁存在，但唯一标识不匹配：表明锁是被其他线程占用，当前线程无权解他人的锁，直接返回锁剩余过期时间\n" +
            "return redis.call('pttl', KEYS[1]);\n";

    public static final String UNLOCK_LUA_SCRIPT = "\n" +
            "-- 若锁不存在：则直接广播解锁消息，并返回1\n" +
            "if (redis.call('exists', KEYS[1]) == 0) then\n" +
            // "    redis.call('publish', KEYS[2], ARGV[1]);\n" +
            "    return 1; \n" +
            "end;\n" +
            " \n" +
            "-- 若锁存在，但唯一标识不匹配：则表明锁被其他线程占用，当前线程不允许解锁其他线程持有的锁\n" +
            "if (redis.call('hexists', KEYS[1], ARGV[3]) == 0) then\n" +
            "    return nil;\n" +
            "end; \n" +
            " \n" +
            "-- 若锁存在，且唯一标识匹配：则先将锁重入计数减1\n" +
            "local counter = redis.call('hincrby', KEYS[1], ARGV[3], -1); \n" +
            "if (counter > 0) then \n" +
            "    -- 锁重入计数减1后还大于0：表明当前线程持有的锁还有重入，不能进行锁删除操作，但可以友好地帮忙设置下过期时期\n" +
            "    redis.call('pexpire', KEYS[1], ARGV[2]); \n" +
            "    return 0; \n" +
            "else \n" +
            "    -- 锁重入计数已为0：间接表明锁已释放了。直接删除掉锁，并广播解锁消息，去唤醒那些争抢过锁但还处于阻塞中的线程\n" +
            "    redis.call('del', KEYS[1]); \n" +
            // "    redis.call('publish', KEYS[2], ARGV[1]); \n" +
            "    return 1;\n" +
            "end;\n" +
            " \n" +
            "return nil;\n";


    @Autowired
    RedisTemplate defaultRedisTemplate;
    //保存当前线程的value值 解锁用
    ThreadLocal local = new ThreadLocal();
    //保存当前设置的失效时间
    ThreadLocal alivetimeLocal = new ThreadLocal();

    private String getLockName() {
        return local.get() + ":" + Thread.currentThread().getId();
    }

    @PostConstruct
    private void init() {
        redisScriptLock = new DefaultRedisScript<>();
        redisScriptLock.setScriptText(LOCK_LUA_SCRIPT);
        redisScriptLock.setResultType(Long.class);
        redisScriptUnLock = new DefaultRedisScript<>();
        redisScriptUnLock.setScriptText(UNLOCK_LUA_SCRIPT);
        redisScriptUnLock.setResultType(Long.class);


    }


    @Override
    public boolean lock(String key, String value, long aliveTime, TimeUnit unit) {
        local.set(value);
        Map amap = new HashMap();
        amap.put("time", unit.toMillis(aliveTime));
        alivetimeLocal.set(amap);
        // System.out.println(Thread.currentThread().getName() + " " + "in...");
        while (true) {
            //不断尝试加锁
            //ttl == null 则加锁成功 不为空时返回的是还有多久过期
            long l = unit.toMillis(aliveTime);
            Long ttl = (Long)defaultRedisTemplate.execute(redisScriptLock, Collections.singletonList(key), l, getLockName());
            if (ttl == null) {
                return true;
            }
        }
    }

    @Override
    public boolean lock(String key, String value, long aliveTime, TimeUnit aliveUnit, long waitTime, TimeUnit waitUnit) {
        long l = waitUnit.toMillis(waitTime) + System.currentTimeMillis();
        local.set(value);
        Map amap = new HashMap();
        amap.put("time", aliveUnit.toMillis(aliveTime));
        alivetimeLocal.set(amap);
        while (waitTime > 0) {
            waitTime = l - System.currentTimeMillis();
            //有限时间内尝试加锁
            Long ttl = (Long)defaultRedisTemplate.execute(redisScriptLock, Collections.singletonList(key), aliveUnit.toMillis(aliveTime), getLockName());
            if (ttl == null) {
                return true;
            }
        }
        //超时返回
        System.out.println(Thread.currentThread().getName()+"--"+"超时返回。。。");
        return false;
    }

    @Override
    public boolean unlock(String key) {
        Map o = ((Map)alivetimeLocal.get());
        if (o != null) {
            long time = ((long)o.get("time"));
            String lockName = getLockName();
            Long res = ((Long)defaultRedisTemplate.execute(redisScriptUnLock, Collections.singletonList(key), "", time, lockName));
            if (res != null && 1 == res) {
                //返回1代表key已删除
                System.out.println("删除key成功：清除threadlocal内容。。");
                local.remove();
                alivetimeLocal.remove();
            }
        }
        return false;
    }
}
