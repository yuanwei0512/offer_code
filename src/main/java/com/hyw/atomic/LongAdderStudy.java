package com.hyw.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/27 21:06
 * Description：TODO
 */
public class LongAdderStudy {

    private static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(20);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            pool.execute(new MyRunnable(longAdder));
        }

        pool.shutdown();
        while (!pool.isTerminated()) {

        }

        long end = System.currentTimeMillis();
        System.out.println(longAdder.sum());
        System.out.println(end - start);


    }

    public static class MyRunnable implements Runnable {

        private LongAdder longAdder;

        public MyRunnable(LongAdder longAdder) {
            this.longAdder = longAdder;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                longAdder.increment();
            }
        }
    }
}


