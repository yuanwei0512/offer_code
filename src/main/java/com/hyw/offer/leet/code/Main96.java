package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/30 17:02
 * Description：TODO
 */
public class Main96 {

    public static void main(String[] args) {
        Main96 main96 = new Main96();
        main96.numTrees(4);
    }

    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }

        }
        return dp[n];
    }

}
