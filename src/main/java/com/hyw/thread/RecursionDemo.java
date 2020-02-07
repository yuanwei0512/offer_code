package com.hyw.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/12 20:23
 * Description：TODO
 */
public class RecursionDemo {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        accessResource();
    }

    private static void accessResource() {

        lock.lock();

        try {
            if (lock.getHoldCount() <= 5 ) {
                accessResource();
                System.out.println("重入");
            }
        } finally {
            lock.unlock();
        }

    }

}
