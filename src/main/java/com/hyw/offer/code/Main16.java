package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/17 11:04
 * Description：TODO
 */
public class Main16 {

    public static void main(String[] args) {

    }

    public double power(double base, double exponent) {

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        boolean isNevigate = false;
        if (exponent < 0) {
            isNevigate = true;
        }

        double powerResult = power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            powerResult *= base;
        }

        return isNevigate ? (1 / powerResult) : powerResult;
    }

}
