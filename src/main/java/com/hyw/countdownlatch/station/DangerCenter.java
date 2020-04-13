package com.hyw.newstudy.station;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/19 20:48
 * Description：TODO
 */
public abstract class DangerCenter implements Runnable {

    protected String station;

    protected boolean isDone;

    protected CountDownLatch countDownLatch;

    public DangerCenter(String station, boolean isDone) {
        this.station = station;
        this.isDone = isDone;
    }

    @Override
    public void run() {
        try {
            checkout();
            isDone = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public boolean isDone() {
        return isDone;
    }

    public abstract void checkout();
}
