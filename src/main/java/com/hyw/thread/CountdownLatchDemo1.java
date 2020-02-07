package com.hyw.thread;

import java.util.concurrent.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/26 10:21
 * Description：TODO
 */
public class CountdownLatchDemo1 {

    public static void main(String[] args) {

        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    int n = finalI;
                    try {
                        start.await();
                        System.out.println(n + "  开始了");
                        Thread.sleep(ThreadLocalRandom.current().nextInt(5) * 1000);
                        System.out.println(n + "  跑完了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }

                }
            };
            pool.execute(runnable);
        }
        try {
            start.countDown();
            end.await();
            System.out.println("所有运动员都结束了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();

    }

}
