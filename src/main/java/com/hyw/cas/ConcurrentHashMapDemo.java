package com.hyw.cas;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/15 14:55
 * Description：TODO
 */
public class ConcurrentHashMapDemo implements Runnable {

    private static final ConcurrentHashMap<String, Integer> scores = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {



        scores.put("小米", 1);
        ConcurrentHashMapDemo r1 = new ConcurrentHashMapDemo();
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r1);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(scores.get("小米"));

    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            while (true) {
                Integer oldValue = scores.get("小米");
                Integer newValue = oldValue + 1;
                System.out.println(Thread.currentThread().getName());
                if (scores.replace("小米", oldValue, newValue)) {
                    break;
                }
            }


        }
    }
}
