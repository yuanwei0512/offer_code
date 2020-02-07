package com.hyw.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/25 16:20
 * Description：TODO
 */
public class ThreadLocalStudy {

    public static ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {



        dateFormat.remove();


        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    ThreadLocalStudy.getDate(finalI);
                }
            });

        }
        pool.shutdown();
    }

    private static void getDate(long time) {
        Date date = new Date(time * 1000);
        synchronized (ThreadLocalStudy.class) {
            String format = simpleDateFormat.format(date);
            System.out.println(format);
        }

    }

}
