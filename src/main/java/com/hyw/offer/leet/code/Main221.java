package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author yuanwei
 * DateTime：2020/4/20 18:07
 * Description：TODO
 */
public class Main221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int y = matrix.length;
        int x = matrix[0].length;
        int result = 0;
        int[][] dp = new int[y][x];
        for (int i = 1; i < y; i++) {
            for (int j = 1; j < x; j++) {
                dp[i][j] = getMin(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    private int getMin(int a, int b, int c) {
        return Math.min(c, Math.min(a, b));
    }

}
