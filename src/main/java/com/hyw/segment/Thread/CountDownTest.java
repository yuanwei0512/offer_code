package com.hyw.segment.Thread;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/3 16:10
 * Description：TODO
 */
public class CountDownTest {

    public static void main(String[] args) {

        final CountDownLatch cdl = new CountDownLatch(10);
        MyRunnable myRunnable = new MyRunnable(cdl);
        Instant start = Instant.now();
        for (int i = 0; i < 10; i++) {
            new Thread(myRunnable).start();
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        System.out.println(between.toMillis());

    }

    public static class MyRunnable implements Runnable{

        private CountDownLatch countDownLatch;

        public MyRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
                System.out.println("test");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.countDownLatch.countDown();
            }

        }
    }


}
