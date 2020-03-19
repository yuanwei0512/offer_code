package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/18 15:35
 * Description：TODO
 */
public class Main326 {

    public boolean isPowerOfThree(int n) {

        int result = n & 3;

        return result == 3 ? true:false;
    }

    public static void main(String[] args) {
        Main326 main326 = new Main326();
        System.out.println(main326.isPowerOfThree(9));
    }

}
