package com.hyw.segment.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/3 16:55
 * Description：TODO
 */
public class TestProductorAndConsumer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Produce produce = new Produce(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(produce).start();
        new Thread(consumer).start();
    }


    public static class Clerk{

        private int product = 0;

        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void get() {
            lock.lock();
            try{
                while (product >= 1){
                    System.out.println("已满");
                    try {
                        condition.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("数量：" + ++product);
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }

        public void sale() {
            lock.lock();
            try {
                while (product <= 0){
                    System.out.println("没有商品了");
                    try {
                        condition.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("数量：" + --product);
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }

    }

    public static class Produce implements Runnable{
        private Clerk clerk;

        public Produce(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                clerk.get();
            }
        }
    }

    public static class Consumer implements Runnable{
        private Clerk clerk;

        public Consumer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                clerk.sale();
            }
        }
    }

}
