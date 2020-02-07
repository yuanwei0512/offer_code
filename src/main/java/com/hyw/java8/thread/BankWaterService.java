package com.hyw.java8.thread;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/12 9:41
 * Description：TODO
 */
public class BankWaterService implements Runnable {

    private CyclicBarrier c = new CyclicBarrier(4, this);

    private ExecutorService exexcutor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetCount = new ConcurrentHashMap<>(4);

    private void count() {
        for (int i = 0; i < 4; i++) {
            exexcutor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetCount.put(Thread.currentThread().getName(), 1);
                    try {
                        c.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> entry : sheetCount.entrySet()) {
            result += entry.getValue();
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }

}
