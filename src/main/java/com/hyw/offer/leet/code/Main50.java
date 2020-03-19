package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/18 15:53
 * Description：TODO
 */
public class Main50 {

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double cur = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return cur * cur;
        } else {
            return cur * cur * x;
        }


    }

    public static void main(String[] args) {
        Main50 main50 = new Main50();
        System.out.println(main50.myPow(2.00000, 10));
    }

}
