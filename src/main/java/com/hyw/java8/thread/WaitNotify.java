package com.hyw.java8.thread;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/6 10:36
 * Description：TODO
 */
public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {

    }

    private static class Wait implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while (flag){
                    try {
                        //
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class Notify implements Runnable{

        @Override
        public void run() {

            synchronized (lock) {
                //
                lock.notifyAll();
                flag = false;
            }
            synchronized (lock){
                //
            }
        }
    }

}
