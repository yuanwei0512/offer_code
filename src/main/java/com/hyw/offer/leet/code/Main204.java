package com.hyw.offer.leet.code;

import java.util.Arrays;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/26 17:15
 * Description：TODO
 */
public class Main204 {

    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                for (int j = i + i; j < n; j += i) {
                    flag[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                count++;
            }
        }
        return count;
    }

}
