package com.zhl.pyg.lock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Zhanghualei
 * @Classname Testcase
 * @Date 2021/3/13 21:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Testcase.class)
@ComponentScan(basePackages = "com.zhl.pyg.**")
public class Testcase {
    @Autowired
    RedisLock rlock;


    @Test
    public void t1() {

        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String my_lock = "my_lock";
        // for (int j = 0; j < 3; j++) {

        // executorService.submit(() -> {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ":线程执行，");
                    boolean lock = rlock.lock(my_lock, String.valueOf(UUID.randomUUID()), 10, TimeUnit.SECONDS);
                    System.out.println("加锁成功，执行业务逻辑。。。");
                    Thread.sleep(1000);
                    latch.countDown();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    rlock.unlock(my_lock);
                    System.out.println("unlock。。。");
                }
            }, "thread:" + i).start();

        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // });
        // }

    }
}
