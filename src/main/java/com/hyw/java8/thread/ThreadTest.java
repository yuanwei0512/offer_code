package com.hyw.java8.thread;

import java.util.concurrent.TimeUnit;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/10 10:30
 * Description：TODO
 */
public class ThreadTest {

    private static final Object lock = new Object();
    private static volatile boolean flag = true;



    public static void main(String[] args) {
        Thread thread1 = new Thread(new singleRunnable());
        Thread thread2 = new Thread(new doubleRunnable());
        thread1.start();
        thread2.start();
        try {
            TimeUnit.SECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static class doubleRunnable implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (!flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("双数");
                    flag = false;
                    lock.notifyAll();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    private static class singleRunnable implements Runnable {

        @Override
        public void run() {

            while (true) {
                synchronized (lock) {
                    while (flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("单数");
                    flag = true;
                    lock.notifyAll();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }


    }

}
