package com.hyw.thread;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/14 9:54
 * Description：TODO
 */
public class Singleton {

    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (instance != null) {
                    instance =new Singleton();
                }
            }
        }
        return instance;
    }

}
