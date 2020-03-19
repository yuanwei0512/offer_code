package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/8 17:20
 * Description：TODO
 */
public class Main1155 {

    public static void main(String[] args) {
        Main1155 main1155 = new Main1155();
        System.out.println(main1155.numRollsToTarget(3, 5, 10));
    }

    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        for (int i = 1; i <= f; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - f < 0) {
                    for (int k = 1; k < j; k++) {
                        dp[i][j] += dp[i - 1][k];
                    }
                } else {
                    for (int k = j - f; k < j; k++) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }
        }
        return dp[d][target];

    }

    public int tryNumRollsToTraget(int d, int f, int target) {
        if (d == 1) {
            if (target >= 1 && target <= f) {
                return 1;
            } else {
                return 0;
            }
        }

        int sum = 0;
        for (int i = 1; i <= f; i++) {
            if (target > d * f) {
                continue;
            }
            sum += tryNumRollsToTraget(d - 1, f, target - i);
        }
        return sum;
    }
}
