package com.hyw.java8.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/10 10:21
 * Description：TODO
 */
public class BoundsQueue<T> {

    private Object[] items;
    private int addIndex, removeIndex, count;
    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();

    public BoundsQueue(int size) {
        items = new Object[size];
    }


    public void add(T t) {
        lock.lock();
        try {
            while (count == items.length) {
                full.await();
            }

            items[addIndex] = t;
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            count++;
            empty.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    @SuppressWarnings("unchecked")
    public T remove() throws InterruptedException {
        lock.lock();

        try {
            while (count == 0 ) {
                empty.await();
            }

            Object x = items[removeIndex];
            if (++removeIndex  == items.length) {
                removeIndex = 0;
            }
            count--;
            full.signal();
            return (T) x;

        }  finally {
            lock.unlock();
        }


    }

}
