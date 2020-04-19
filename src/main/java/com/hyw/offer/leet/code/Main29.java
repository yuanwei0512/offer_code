package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/26 14:56
 * Description：TODO
 */
public class Main29 {

    public static void main(String[] args) {
        Main29 main29 = new Main29();
        System.out.println(main29.divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {

        boolean isNegtive = false;
        if (dividend > 0 ^ divisor > 0) {
            isNegtive = true;
            dividend = -dividend;
        }
        int result = 0;
        int sum = divisor;
        while (Math.abs(sum) <= Math.abs(dividend)) {
            sum += divisor;
            result++;
        }
        if (isNegtive) {
            return -result;
        }
        return result;
    }

}
