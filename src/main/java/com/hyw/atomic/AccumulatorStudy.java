package com.hyw.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/28 9:54
 * Description：TODO
 */
public class AccumulatorStudy {

    public static void main(String[] args) {
        LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y, 0);

        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            pool.execute(() -> {
                longAccumulator.accumulate(finalI);
            });
        }


        pool.shutdown();
        while (!pool.isTerminated()) {

        }

        System.out.println(longAccumulator.get());


    }

}
