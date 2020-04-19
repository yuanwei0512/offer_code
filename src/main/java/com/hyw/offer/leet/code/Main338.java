package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/12 16:44
 * Description：TODO
 */
public class Main338 {

    public static void main(String[] args) {
        Main338 main338 = new Main338();
        System.out.println(main338.countBits(4));
    }

    public int[] countBits(int num) {

        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;

    }

}
