package com.hyw.segment.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/3 16:25
 * Description：TODO
 */
public class FutureTaskTest {

    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> task = new FutureTask<>(myCallable);

        new Thread(task).start();

        try {
            Integer result = task.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i <= 100; i++) {

                sum += i;
            }
            return sum;
        }
    }

}
