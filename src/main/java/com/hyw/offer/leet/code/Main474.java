package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/2 15:12
 * Description：TODO
 */
public class Main474 {

    private boolean[] validate;

    public int findMaxForm(String[] strs, int m, int n) {

        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] ints = countO1(str);
            for (int j = m; j >= ints[0]; j--) {
                for (int k = n; k >= ints[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k],  dp[j - ints[0]][k - ints[1]] + 1);
                }
            }
        }
        return dp[m][n];

    }
    private int[] countO1(String str) {
        int[] count = new int[2];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - '0']++;
        }
        return count;
    }
    /**
     *         if (strs == null || strs.length == 0) {
     *             return 0;
     *         }
     *         validate = new boolean[strs.length];
     *         return tryFindMaxForm(strs, m, n);
     */
    private int tryFindMaxForm(String[] strs, int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (validate[i]) {
                continue;
            }
            int[] ints = countO1(strs[i]);

            if (ints[0] <= m && ints[1] <= n) {
                validate[i] = true;
                res = Math.max(res, tryFindMaxForm(strs, m - ints[0], n - ints[1]));
                validate[i] = false;
            }
        }

        if (res == Integer.MIN_VALUE) {
            return 0;
        }
        return res + 1;
    }


    public static void main(String[] args) {
        String[] array = {"10", "0", "1"};
        Main474 main474 = new Main474();
        System.out.println(main474.findMaxForm(array, 1, 1));
    }

}
