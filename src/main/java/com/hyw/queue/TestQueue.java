package com.hyw.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/7 11:05
 * Description：TODO
 */

public class TestQueue {

    private final static MyQueue<String> queue = new MyLinkedListBlockingQueue<>(10);
    // 生产者
    public static class Product implements Runnable {
        private final String message;
        public Product(String message) {
            this.message = message;
        }
        @Override
        public void run() {
            try {
                queue.put(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class Consumer implements Runnable{
        @Override
        public void run() {
            try {
                String message = (String) queue.take();
                System.out.println(message);
            } catch (Exception e) {

            }
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        Consumer consumer = new Consumer();
        for (int i = 0; i < 50; i++) {
            Product product = new Product("message" + i);
            if (i % 2 == 0) {
                //executorService.execute(product);
            } else {
                executorService.execute(consumer);
            }
        }

    }

}
