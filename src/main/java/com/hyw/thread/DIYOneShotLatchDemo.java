package com.hyw.thread;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/27 10:25
 * Description：TODO
 */
public class DIYOneShotLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        DIYOneShotLatchDemo dyaOneShotLatchDemo = new DIYOneShotLatchDemo();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), new ThreadFactory() {
            private volatile int n = 0;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "TestThread" + n++);

            }
        });


        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "开始等待");
                dyaOneShotLatchDemo.await();
                System.out.println(Thread.currentThread().getName() +"开始运行");
            });
        }

        TimeUnit.SECONDS.sleep(5);
        dyaOneShotLatchDemo.signal();
        executor.shutdown();
    }


    private final Sync sync = new Sync();

    public void signal() {
        sync.releaseShared(0);
    }

    public void await() {
        sync.acquireShared(0);
    }


    private final static class Sync extends AbstractQueuedSynchronizer {


        @Override
        protected int tryAcquireShared(int arg) {
            return getState() == 0 ? -1 : 1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);
            return true;
        }
    }

}
