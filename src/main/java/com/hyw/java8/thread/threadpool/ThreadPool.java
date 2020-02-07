package com.hyw.java8.thread.threadpool;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/8 8:54
 * Description：TODO
 */
public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorker(int num);

    int getJobSize();

}
