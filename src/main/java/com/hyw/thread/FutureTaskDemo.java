package com.hyw.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/2 23:17
 * Description：TODO
 */
public class FutureTaskDemo {

    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<Integer>(() -> 5);
        new Thread(task).start();
        try {
            Integer integer = task.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
