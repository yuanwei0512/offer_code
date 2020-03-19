package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/26 15:09
 * Description：TODO
 */
public class Main279 {

    private int[] memory;

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int x = (int) Math.sqrt(i);
            if (x * x == i) {
                dp[i] = 1;
                continue;
            }

            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j < i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }

        }
        return dp[n];

    }

    /**
     * memory = new int[n + 1];
     * numSqur(n);
     * return  memory[n];
     *
     * @param n
     * @return
     */
    private int numSqur(int n) {

        if (memory[n] != 0) {
            return memory[n];
        }

        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            memory[n] = 1;
            return 1;
        }

        int minResult = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            minResult = Math.min(minResult, numSqur(n - i * i) + 1);
        }
        memory[n] = minResult;
        return minResult;
    }

    public static void main(String[] args) {
        Main279 main279 = new Main279();
        System.out.println(main279.numSquares(12));
    }

}
