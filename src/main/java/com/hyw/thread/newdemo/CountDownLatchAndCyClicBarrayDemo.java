package com.hyw.thread.newdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/18 10:51
 * Description：TODO
 */
public class CountDownLatchAndCyClicBarrayDemo {

    private List<Order> noSccuessOrder = new ArrayList<>();

    private final LinkedBlockingQueue<Order> dordersQueue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<Order> pordersQueue = new LinkedBlockingQueue<>();

    public void checkPandDOrder() throws InterruptedException {
        ExecutorService checkPool = Executors.newFixedThreadPool(1);
        ExecutorService getOrderPool = Executors.newFixedThreadPool(2);

        CountDownLatch endLatch = new CountDownLatch(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                check();
            }
        });

        getOrderPool.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("执行D" + i);
                dordersQueue.add(getDOrder());
                try {
                    cyclicBarrier.await();

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
            endLatch.countDown();
        });

        getOrderPool.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("执行P" + i);
                pordersQueue.add(getPOrder());
                try {
                    cyclicBarrier.await();

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
            endLatch.countDown();
        });
        getOrderPool.shutdown();
        checkPool.shutdown();
        endLatch.await();
    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatchAndCyClicBarrayDemo demo = new CountDownLatchAndCyClicBarrayDemo();
        demo.checkPandDOrder();
        System.out.println(demo.noSccuessOrder.size());
    }

    private void check(){
        System.out.println("执行check");
        Order dOrder = dordersQueue.poll();
        Order pOrder = pordersQueue.poll();
        if (dOrder != null && pOrder != null) {
            noSccuessOrder.add(pOrder);
        }
        System.out.println("执行完check");
    }




    private Order getDOrder() {
        return new Order(UUID.randomUUID().toString(), 5);
    }

    private Order getPOrder() {
        return new Order(UUID.randomUUID().toString(), 5);
    }



}
