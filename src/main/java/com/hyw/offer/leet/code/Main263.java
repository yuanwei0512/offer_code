package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author yuanwei
 * DateTime：2020/4/21 11:54
 * Description：TODO
 */
public class Main263 {

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        if (num == 1) {
            return true;
        } else {
            return false;
        }

    }

}
