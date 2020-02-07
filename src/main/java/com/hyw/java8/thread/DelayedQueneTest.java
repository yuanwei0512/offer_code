package com.hyw.java8.thread;

import javax.swing.plaf.PanelUI;
import java.util.concurrent.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/11 9:37
 * Description：TODO
 */
public class DelayedQueneTest {

    public static void main(String[] args) {
        DelayQueue<Message> queue = new DelayQueue<>();
        Message m1 = new Message(1, "world", 1000);
        Message m2 = new Message(2, "hello", 2000);
        queue.offer(m1);
        queue.offer(m2);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Consumer(queue));
    }


    public static class Consumer implements Runnable {

        private DelayQueue<Message> queue;

        public Consumer(DelayQueue<Message> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Message take = queue.take();
                    System.out.println("消费者id" + take.getId() + "内容" + take.getBody());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static class Message implements Delayed {
        private int id;
        private String body;
        private long excuteTime;
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }

        public Message(int id, String body, long delayTime) {
            this.id = id;
            this.body = body;
            this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        }

        public int getId() {
            return id;
        }

        public String getBody() {
            return body;
        }

        public long getExcuteTime() {
            return excuteTime;
        }
    }

}
