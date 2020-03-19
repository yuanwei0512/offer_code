package com.hyw.offer.leet.code;

import java.util.Arrays;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/17 15:50
 * Description：TODO
 */
public class Main7 {

    public int reverse(int x) {

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if ((rev > Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && pop == 7)) {
                return 0;
            }

            if ((rev < Integer.MIN_VALUE / 10) || (rev == Integer.MIN_VALUE / 10 && pop == -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        Main7 main7 = new Main7();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

}
