package com.hyw.thread;

import java.util.PriorityQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/26 11:39
 * Description：TODO
 */
public class ConditionDemo2 {

    public static int queueSize = 10;
    public static PriorityQueue<Integer> queue = new PriorityQueue<>();
    public static Lock lock = new ReentrantLock();
    public static Condition notEmpty = lock.newCondition();
    public static Condition notFull = lock.newCondition();

    public static void main(String[] args) {
        ConditionDemo2 conditionDemo = new ConditionDemo2();
        Produce produce = new Produce();
        Consumer consumer = new Consumer();
        consumer.start();
        produce.start();
        new ReentrantLock();

    }

    public static class Produce extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == queueSize) {
                        System.out.println("队列满");
                        notFull.await();
                    }
                    queue.offer(1);
                    System.out.println("放入一个元素");
                    notEmpty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    public static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("队列空了");
                        notEmpty.await();
                    }
                    queue.poll();
                    System.out.println("取出一个元素");
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }


}
