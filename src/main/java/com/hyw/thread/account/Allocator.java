package com.hyw.thread.account;

import java.util.HashSet;
import java.util.Set;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/15 9:58
 * Description：TODO
 */
public class Allocator {

    private Set<Account> als = new HashSet<>();

    private static volatile Allocator instance;

    public synchronized boolean applay(Account from, Account to) {
        while (als.contains(from) || als.contains(to)) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        als.add(to);
        als.add(from);
        return true;
    }

    public synchronized void free(Account from, Account to) {
        als.remove(from);
        als.remove(to);
        this.notifyAll();
    }

    public static Allocator getInstance() {
        if (null == instance) {
            synchronized (Allocator.class) {
                if (null == instance) {
                    instance = new Allocator();
                }
            }
        }
        return instance;
    }


}
