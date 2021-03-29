package com.zhl.pyg.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author Zhanghualei
 * @Classname RLock
 * @Date 2021/3/13 17:37
 */
public interface Rlock {
    /**
     * 阻塞锁
     * @author zhanghualei
     * @date 2021/3/13 17:43
     * @param key
     * @param value
     * @param aliveTime
     */
    boolean lock(String key, String value, long aliveTime, TimeUnit aliveUnit);
    /**
     * 非阻塞锁 尝试多久后就返回
     * @author zhanghualei
     * @date 2021/3/13 17:45
     * @param key
     * @param value
     * @param aliveTime
     * @param waitTime 尝试多久
     */
    boolean lock(String key,String value,long aliveTime,TimeUnit aliveUnit,long waitTime,TimeUnit waitUnit);

    boolean unlock(String key);
}
