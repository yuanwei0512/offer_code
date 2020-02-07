package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/2 13:33
 * Description：TODO
 */
public class Main10 {

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int pre2 = 0;
        int pre1 = 1;
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
