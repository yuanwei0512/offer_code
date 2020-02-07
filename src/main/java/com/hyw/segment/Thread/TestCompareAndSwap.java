package com.hyw.segment.Thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/3 15:17
 * Description：TODO
 */
public class TestCompareAndSwap {

    public static void main(String[] args) {
        CompareAndSwap cas = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {

                    int oldValue = cas.get();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(cas.compareAndSet(oldValue, ThreadLocalRandom.current().nextInt(20)));
                }
            }).start();
        }
    }
    
    public static class CompareAndSwap{
        private int value;

        public int get(){
            return value;
        }

        public synchronized  int compareAndSwap(int expectedValue, int newValue){
            int oldValue = value;
            if (oldValue == expectedValue){
                this.value = newValue;
            }
            return oldValue;
        }

        public synchronized boolean compareAndSet(int expectedValue, int newValue){
            return expectedValue == compareAndSwap(expectedValue, newValue);
        }
    }

}
