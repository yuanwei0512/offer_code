package com.hyw.threadpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/19 10:13
 * Description：TODO
 */
public class MyThreadPool {

    private BlockingQueue<Runnable> workQueue;
    private List<WorkerThread> threads;
    private volatile int count;

    private final int  threadSize;

    public MyThreadPool(int threadSize, BlockingQueue<Runnable> workQueue) {
        this.threadSize = threadSize;
        this.workQueue = workQueue;

        threads = new ArrayList<>(threadSize);
        for (int i = 0; i < threadSize; i++) {
            threads.add(new WorkerThread());
        }
    }

    public void execute(Runnable runnable) {
        workQueue.add(runnable);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!workQueue.isEmpty() && count < threadSize) {
            System.out.println("创建线程" + count);
            threads.get(count++).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Runnable> runnables = new ArrayBlockingQueue<Runnable>(20);
        MyThreadPool myThreadPool = new MyThreadPool(10, runnables);
        int count = 0;
        myThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("添加任务");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.sleep(200);
        myThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("添加任务");
            }
        });
    }


    private class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable take = workQueue.take();
                    take.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
