package com.hyw.segment.Thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/3 14:45
 * Description：TODO
 */
public class AtomicDemo{

    private static AtomicIntegerFieldUpdater<User> ai = AtomicIntegerFieldUpdater
            .newUpdater(User.class,"old");


    public static void main(String[] args) {

        User user = new User("hh", 12);
        ai.getAndIncrement(user);
        System.out.println(user);
    }


    public static class User{
        private String name;
        public volatile int old;

        public User(String name, int old) {

            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOld() {
            return old;
        }

        public void setOld(int old) {
            this.old = old;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", old=" + old +
                    '}';
        }
    }

}
