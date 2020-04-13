package com.hyw.newstudy;

import com.hyw.newstudy.station.DangerCenter;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/19 20:47
 * Description：TODO
 */
public class CheckStartUp {

    private List<DangerCenter> checkCenter;
    private CountDownLatch countDownLatch;

    private static final ExecutorService pool;

    static {
        int processors = Runtime.getRuntime().availableProcessors();
        pool = new ThreadPoolExecutor(processors, processors,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), new MyThreadFactory());
    }

    public CheckStartUp(List<DangerCenter> checkCenter) {
        this.checkCenter = checkCenter;
        countDownLatch = new CountDownLatch(checkCenter.size());
    }

    public boolean checkStart() throws InterruptedException {
        for (DangerCenter dangerCenter : checkCenter) {
            dangerCenter.setCountDownLatch(this.countDownLatch);
            pool.execute(dangerCenter);
        }
        countDownLatch.await();
        for (DangerCenter dangerCenter : checkCenter) {
            if (!dangerCenter.isDone()) {
                return false;
            }
        }
        return true;
    }



    /**
     * The default thread factory
     */
    static class MyThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                    poolNumber.getAndIncrement() +
                    "-chekStartUp-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

}
