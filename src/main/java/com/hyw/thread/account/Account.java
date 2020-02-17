package com.hyw.thread.account;

import java.util.concurrent.Semaphore;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/15 9:57
 * Description：TODO
 */
public class Account {

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void transfer(Account target, int amt) {
        Allocator.getInstance().applay(this, target);

        try {
            this.balance -= amt;
            target.balance += amt;
        } finally {
            Allocator.getInstance().free(this, target);
            System.out.println("this balance" + this.balance+ "   target balance"+target.balance);
        }


    }


}
