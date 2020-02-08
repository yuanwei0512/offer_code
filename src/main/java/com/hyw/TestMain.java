package com.hyw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/7 22:14
 * Description：TODO
 */
public class TestMain {



    public static void main(String[] args) {
        //主线程中赋值
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

        InheritableThreadLocal<String> stringInheritableThreadLocal = new InheritableThreadLocal<>();

        stringThreadLocal.set("ThreadLocal string");
        stringInheritableThreadLocal.set("InheritableThreadLocal string");

        //子线程中分别打印两个变量的信息
        new Thread(() -> {
            System.out.println(
                    Thread.currentThread().getName() + " ThreadLocal value ：" + stringThreadLocal.get());
            System.out.println(Thread.currentThread().getName() + " InheritableThreadLocal value ："
                    + stringInheritableThreadLocal.get());
        }).start();


    }

}
