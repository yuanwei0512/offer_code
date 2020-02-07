package com.hyw.cart;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/11/23 9:46
 * Description：TODO
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (singleton ==null) {
            synchronized (Singleton.class){
                if (singleton ==null) {
                    singleton = new Singleton();

                }
            }
        }
        return singleton;
    }

}
