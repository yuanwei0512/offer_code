package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/29 17:16
 * Description：TODO
 */
public class Main231 {

    public static void main(String[] args) {
        Main231 main231 = new Main231();
        System.out.println(main231.isPowerOfTwo(16));
    }

    public boolean isPowerOfTwo(int n) {

        if (n < 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

}
