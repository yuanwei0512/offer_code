package com.hyw;

import java.io.*;

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

    public void methodB(){
        try {

            methodA();

        } catch (Exception e) {
            System.out.println("methoddddd b ");
        }

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("asdf"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("asdf"))) {

            byte[] buffer = new byte[8192];
            int len = 0;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void methodA() {
        System.out.println("进入methodA");
        throw new IllegalArgumentException("a");
    }

}
