package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/29 14:59
 * Description：TODO
 */
public class Knapsack01 {

    private int[][] memory;

    public int kanapsack01(int[] weights, int[] values, int c) {


        int[] dp = new int[c + 1];
        for (int j = 0; j <= c; j++) {
            dp[j] = (j >= weights[0] ? values[0] : 0);
        }

        for (int i = 1; i < weights.length; i++) {
            for (int j = c; j >= weights[i]; j--) {

                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);

            }
        }
        return dp[c];

    }

    /**
     * if (weights == null || values == null || values.length == 0 || weights.length != values.length) {
     * return 0;
     * }
     * memory = new int[c + 1][weights.length];
     * return bestValue(weights, values, c, weights.length - 1);
     */
    private int bestValue(int[] weights, int[] values, int c, int index) {

        if (c <= 0 || index < 0) {
            return 0;
        }
        if (memory[c][index] != 0) {
            return memory[c][index];
        }
        int res = bestValue(weights, values, c, index - 1);

        if (weights[index] <= c) {
            res = Math.max(res, bestValue(weights, values, c - weights[index], index - 1) + values[index]);
        }
        memory[c][index] = res;
        return res;
    }

    public static void main(String[] args) {
        Knapsack01 knapsack01 = new Knapsack01();
        int[] weight = {2, 3, 5, 7};
        int[] value = {1, 5, 2, 4};
        System.out.println(knapsack01.kanapsack01(weight, value, 10));
    }

}
