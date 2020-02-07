package com.hyw.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/27 20:22
 * Description：TODO
 */
public class AtomicStudy implements Runnable {

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    private static volatile int basicInteger = 0;

    private void atomicIncrement() {
        atomicInteger.getAndIncrement();
    }

    private void basicIncrement() {
        synchronized (AtomicInteger.class){
            basicInteger++;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        AtomicStudy atomicStudy = new AtomicStudy();

        Thread thread1 = new Thread(atomicStudy);
        Thread thread2 = new Thread(atomicStudy);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(atomicInteger.get());
        System.out.println(basicInteger);
    }


    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            atomicIncrement();
            basicIncrement();
        }
    }
}
