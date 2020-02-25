package com.hyw.offer.leet.code;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/25 15:18
 * Description：TODO
 */
public class Main120 {




    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int maxCol = triangle.get(row - 1).size();

        int[][] dp = new int[row][maxCol];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + triangle.get(i).get(j), dp[i - 1][j] + triangle.get(i).get(j));
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i : dp[row - 1]) {
            result = Math.min(result, i);
        }
        return result;

    }

    public static void main(String[] args) {
        Main120 main120 = new Main120();

        List<Integer> list = Arrays.asList(2);
        List<Integer> list1 = Arrays.asList(3, 4);
        List<Integer> list2 = Arrays.asList(6, 5, 7);
        List<Integer> list3 = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> triangle = Arrays.asList(list, list1, list2, list3);


        System.out.println(main120.minimumTotal(triangle));
    }

}
