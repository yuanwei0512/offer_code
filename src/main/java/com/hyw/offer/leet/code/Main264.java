package com.hyw.offer.leet.code;

import java.util.HashSet;
import java.util.Set;

/**
 * Project：study_996     @author yuanwei
 * DateTime：2020/4/21 13:37
 * Description：TODO
 */
public class Main264 {

    public int nthUglyNumber(int n) {
        if (n <= 1) {
            return n;
        }
        int num2 = 1;
        int num3 = 1;
        int num5 = 1;
        int curNum = 1;
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        while (true) {
            int curValue = Math.min(Math.min(num2 * 2, num3 * 3), num5 * 5);
            if (num2 * 2 == curValue) {
                num2++;
                while (!set.contains(num2)) {
                    num2++;
                }

            }
            if (num3 * 3 == curValue) {
                num3++;
                while (!set.contains(num3)) {
                    num3++;
                }
            }
            if (num5 * 5 == curValue) {
                num5++;
                while (!set.contains(num5)) {
                    num5++;
                }
            }
            curNum++;
            set.add(curValue);
            if (curNum == n) {
                return curValue;
            }
        }
    }

    public static void main(String[] args) {
        Main264 main264 = new Main264();
        System.out.println(main264.nthUglyNumber(11));
    }

}
