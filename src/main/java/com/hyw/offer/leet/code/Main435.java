package com.hyw.offer.leet.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/5 15:59
 * Description：TODO
 */
public class Main435 {


    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int res = 1;
        int pre = 0;

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= intervals[pre][1]) {
                res += 1;
                pre = i;
            }

        }
        return intervals.length - res;
        

        /*if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int[] dp = new int[intervals.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int maxContent = 1;
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1] || intervals[i][1] <= intervals[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxContent = Math.max(maxContent, dp[i]);
                }
            }
        }
        return intervals.length - maxContent;*/
    }

    public static void main(String[] args) {
        Main435 main435 = new Main435();
        int[][] nums = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(main435.eraseOverlapIntervals(nums));
    }

}
