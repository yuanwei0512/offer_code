package com.hyw.cache;

import com.hyw.cache.computable.ExpensiveFunction;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/4 20:47
 * Description：TODO
 */
public class MyCacheTest2 {

    public static final MyCache2<String, Integer> MY_CACHE = new MyCache2<>(new ExpensiveFunction());

    public static ThreadLocal<SimpleDateFormat> THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));

    public static void main(String[] args) {



        CountDownLatch countDownLatch = new CountDownLatch(1);

        ThreadFactory threadFactory = new ThreadFactory() {
            private int n = 0;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "ThreadPoll-" + n++);
            }
        };

        ThreadPoolExecutor pool = new ThreadPoolExecutor(50,
                80,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(100), threadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());

        Instant startTime = Instant.now();

        for (int i = 0; i < 200; i++) {
            int finalI = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    Integer compute = null;
                    try {
                        compute = MY_CACHE.compute("666");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String time = THREAD_LOCAL.get().format(new Date());
                    System.out.println(compute + " time:" + time + "   " + finalI);
                }
            });
        }

        pool.shutdown();
        while (!pool.isTerminated()) {

        }

        Instant enTime = Instant.now();
        System.out.println(ChronoUnit.MILLIS.between(startTime, enTime));

    }

}
