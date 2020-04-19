package com.hyw;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/7 22:14
 * Description：TODO
 */
public class TestMain {

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.methodB();
    }

    public void methodB() {


        try {
            methodA();
        } catch (Exception e) {
            System.out.println("method b ");
        }
    }

    public void methodA() {
        System.out.println("进入methodA");
        throw new IllegalArgumentException("a");
    }

}
