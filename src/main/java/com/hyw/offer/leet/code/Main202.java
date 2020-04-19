package com.hyw.offer.leet.code;

import java.util.HashSet;
import java.util.Set;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/13 11:25
 * Description：TODO
 */
public class Main202 {


    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = change(n);
            if (set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }

    public int change(int n) {
        int sum = 0;
        int num;
        while (n != 0) {
            num = n % 10;
            n /= 10;
            sum += num * num;
        }
        return sum;
    }



    public static void main(String[] args) {

    }

}
