package com.hyw.cas;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/28 10:22
 * Description：TODO
 */
public class CASDemo implements Runnable {

    private volatile int value;

    public synchronized int compareAndSwap(int expectValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectValue) {
            value = newValue;
            return newValue;
        }
        return oldValue;
    }

    public static void main(String[] args) throws InterruptedException {
        CASDemo casDemo = new CASDemo();
        casDemo.value = 0;

        Thread thread = new Thread(casDemo, "thread1");
        Thread thread2 = new Thread(casDemo, "thread2");

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

    }


    @Override
    public void run() {
        compareAndSwap(0, 1);
    }
}
