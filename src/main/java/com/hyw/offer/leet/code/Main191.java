package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/19 16:24
 * Description：TODO
 */
public class Main191 {

    public int hammingWeight(int n) {
        int size = 0;
        while (n != 0) {
            size++;
            n = n & (n - 1);
        }
        return size;
    }


}
