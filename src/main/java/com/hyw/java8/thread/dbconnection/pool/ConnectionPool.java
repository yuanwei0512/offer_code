package com.hyw.java8.thread.dbconnection.pool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/7 20:30
 * Description：TODO
 */
public class ConnectionPool {

    private List<Connection> pool = new ArrayList<>();

    public ConnectionPool(int initialSize){
        if (initialSize > 0){
            for (int i = 0; i < initialSize; i++) {
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if (null != connection){
            synchronized (pool) {
                pool.add(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
            } else {
                long future = System.currentTimeMillis() + mills;
                long remmainning = mills;
                while (pool.isEmpty() && remmainning > 0){
                    pool.wait(remmainning);
                    remmainning = future - System.currentTimeMillis();
                }
            }
            Connection result = null;
            if (!pool.isEmpty()) {
                result = pool.remove(0);
            }
            return result;


        }
    }

}
