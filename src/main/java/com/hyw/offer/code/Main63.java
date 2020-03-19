package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/9 16:41
 * Description：TODO
 */
public class Main63 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        Main63 main63 = new Main63();
        int[] nums = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(main63.maxProfit(nums));
    }

}
