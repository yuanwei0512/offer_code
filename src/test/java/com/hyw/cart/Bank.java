package com.hyw.cart;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/11/29 9:10
 * Description：TODO
 */
public class Bank {

    private final double[] accounts;
    private Lock bancLock;
    private Condition sufficientFound;

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        try {
            bancLock.lock();
            while(accounts[from] < amount){
                sufficientFound.await();
            }

            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", from, to, amount);
            accounts[to] += amount;

            sufficientFound.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bancLock.unlock();
        }
    }



}
