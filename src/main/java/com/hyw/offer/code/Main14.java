package com.hyw.offer.code;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/15 10:17
 * Description：TODO
 */
public class Main14 {

    /**
     *
     * @param n 绳子长度
     * @return 动态规则
     */
    public int integerBreak2(int n) {



        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }

    /**
     * @param n 绳子的长度
     * @return 贪心算法
     */
    public int integerBreak(int n) {

        if (n < 2) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        int temsOf3 = n / 3;
        if (n - temsOf3 * 3 == 1) {
            temsOf3 -= 1;
        }
        int temsOf2 = (n - temsOf3 * 3) / 2;
        return ((int)Math.pow(temsOf3, 3) * (int)Math.pow(temsOf2, 2));

    }

}
