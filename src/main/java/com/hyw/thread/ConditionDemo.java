package com.hyw.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/26 10:59
 * Description：TODO
 */
public class ConditionDemo {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void method1() {
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                conditionDemo.method2();
            }
        }).start();
        conditionDemo.method1();

    }

}
