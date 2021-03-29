package com.zhl.pyg.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhanghualei
 * @Classname App
 * @Date 2021/3/13 22:11
 */
// @SpringBootApplication
public class AppLock {
    public AppLock(RedisTemplate redisTemplate, RedisLock rlock) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String my_lock = "my_lock";
        // for (int j = 0; j < 3; j++) {

        // executorService.submit(() -> {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                t1(rlock, my_lock);
            }, "thread:" + i).start();

        }
    }

    private void t1(RedisLock rlock, String my_lock) {
        try {
            String value = String.valueOf(UUID.randomUUID());
            boolean lock = rlock.lock(my_lock, value, 1000, TimeUnit.SECONDS,5,TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + ":线程执行，");
            System.out.println("加锁成功，执行业务逻辑。。。");
            t2(rlock,my_lock,value);
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rlock.unlock(my_lock);
            System.out.println("unlock。。。");
        }
    }

    private void t2(RedisLock rlock, String my_lock, String value) {
        try {
            System.out.println("重入");
            boolean lock = rlock.lock(my_lock, value, 1000, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + ":线程执行，22222222");
            System.out.println("加锁成功，执行业务逻辑。。。2222222");
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rlock.unlock(my_lock);
            System.out.println("unlock。。。222222");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(AppLock.class, args);
    }
}
