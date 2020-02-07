package com.hyw.deadlock;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/11/23 19:39
 * Description：TODO
 */
public class MustDeadLock {

    private static String a = "A";
    private static String b = "b";

    public static void main(String[] args) {
        MustDeadLock deadLock = new MustDeadLock();
        deadLock.deadLock();
    }

    private void deadLock(){
        Thread thread1 = new Thread(() -> {
            synchronized (a){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("a获取到了锁");
                }

            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (b){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println("b获取到了锁");
                }

            }
        });
        thread1.start();
        thread2.start();

    }

}
