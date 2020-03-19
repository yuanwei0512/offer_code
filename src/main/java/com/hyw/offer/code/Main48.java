package com.hyw.offer.code;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/11 17:12
 * Description：TODO
 */
public class Main48 {

    public static void main(String[] args) {
        Main48 main48 = new Main48();
        System.out.println(main48.longestSubstring("arabcacfr"));
    }
    public int longestSubstring(String str) {
        int n = str.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int num = dp[i - 1];
            int same = -1;
            for (int j = i - num; j < i; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    same = j;
                }
            }
            if (same == -1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i]= i - same;
            }
        }
        return dp[n - 1];

    }

}
