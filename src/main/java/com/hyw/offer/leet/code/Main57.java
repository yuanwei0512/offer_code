package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/19 15:58
 * Description：TODO
 */
public class Main57 {

    public static void main(String[] args) {
        Main57 main57 = new Main57();
        int[][] result = main57.findContinuousSequence(9);

    }

    public int[][] findContinuousSequence(int target) {

        List<int[]> resultList = new ArrayList<>();
        int left = 1;
        int right = 2;
        int sum = 3;
        while (left < right && right < target) {
            if (sum == target) {
                int[] segment = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    segment[i - left] = i;
                }
                resultList.add(segment);
                sum -= left;
                left++;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }

}
