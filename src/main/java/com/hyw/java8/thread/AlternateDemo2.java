package com.hyw.java8.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/8 10:11
 * Description：TODO
 */
public class AlternateDemo2 {

    private volatile int number = 1;

    private final Object lock = new Object();

    public void loopA(CountDownLatch start) {
        try {
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            while (number != 1) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A");
            lock.notifyAll();
            number = 2;
        }



    }

    public void loopB(CountDownLatch start) {

        try {
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            while (number != 2) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            lock.notifyAll();
            number = 3;
        }

    }

    public void loopC(CountDownLatch start) {

        try {
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            while (number != 3) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
            lock.notifyAll();
            number = 1;
        }

    }

}
