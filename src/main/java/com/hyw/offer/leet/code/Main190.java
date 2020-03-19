package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/17 16:12
 * Description：TODO
 */
public class Main190 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cur = n & 1;
            res += cur<<(31 -i);
            n = n>>1;
        }
        return res;
    }

}
