package com.hyw.java8.thread.dbconnection.pool;

import java.sql.Connection;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/7 20:54
 * Description：TODO
 */
public class ConnectionPoolTest {

    private static final ConnectionPool pool = new ConnectionPool(10);

    private static final CountDownLatch start = new CountDownLatch(1);

    private static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger noGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            new Thread(new ConnectionRunner(count, got, noGot)).start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke" + (threadCount * count));
        System.out.println("got connection" + got);
        System.out.println("noGot connection" + noGot);
    }

    static class ConnectionRunner implements Runnable{

        int count;
        AtomicInteger got;
        AtomicInteger noGot;

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (count > 0){
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (null != connection) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        noGot.decrementAndGet();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger noGot) {
            this.count = count;
            this.got = got;
            this.noGot = noGot;
        }


    }

}
