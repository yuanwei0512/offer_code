package com.hyw.java8.thread.threadpool;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/8 8:51
 * Description：TODO
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    private static final int MAX_WORKER_NUMBERS = 10;

    private static final int DEFAULT_WORKER_NUMBERS = 5;

    private static final int MIN_WORKER_NUMBERS = 1;

    private final List<Job> jobs = new LinkedList<Job>();

    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    private int workerNum = DEFAULT_WORKER_NUMBERS;

    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initalizeWorker(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS :
                num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS :num;
        initalizeWorker(workerNum);
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (jobs) {
                jobs.add(job);
                notify();
            }
        }

    }

    @Override
    public void shutdown() {
        workers.forEach(Worker::shutdown);
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initalizeWorker(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        if (num > this.workerNum) {
            throw new IllegalArgumentException("beyond workNum");
        }

        int count = 0;
        while (count <= num) {
            Worker worker = workers.get(0);
            if (workers.remove(worker)) {
                worker.shutdown();
                count++;
            }
        }
        this.workerNum -= count;
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initalizeWorker(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            new Thread(worker, "ThreadPool-worker" + threadNum.getAndIncrement()).start();
        }
    }

    private class Worker implements Runnable{

        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    job = jobs.remove(0);
                }

                if (null != job) {
                    job.run();
                }

            }
        }

        public void shutdown(){
            running = false;
        }
    }

}
