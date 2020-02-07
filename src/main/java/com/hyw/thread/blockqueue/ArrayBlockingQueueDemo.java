package com.hyw.thread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/16 10:09
 * Description：TODO
 */
public class ArrayBlockingQueueDemo {


    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);

        Thread thread1 = new Thread(new Produce(queue));
        Thread thread2 = new Thread(new Consumer(queue));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static class Consumer implements Runnable{

        private ArrayBlockingQueue<String> queue;

        public Consumer(ArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            String msg;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                while (!(msg = queue.take()).equals("stop")) {
                    System.out.println(msg + "已经消费");
                }
                System.out.println("所有都消费完了");
            } catch (InterruptedException e) {

            }

        }
    }


    public static class Produce implements Runnable{

        private ArrayBlockingQueue<String> queue;

        public Produce(ArrayBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                String candidate = "candidate" + i;
                try {
                    queue.put(candidate);
                    System.out.println(candidate + "入队");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                queue.put("stop");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
