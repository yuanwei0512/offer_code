package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/20 13:59
 * Description：TODO
 */
public class Main56 {

    public static void main(String[] args) {
        Main56 main56 = new Main56();
        int[][] nums = {{1, 4}, {4, 5}};
        int[][] merge = main56.merge(nums);
        for (int i = 0; i < merge.length; i++) {
            System.out.print("[");
            for (int j = 0; j < 2; j++) {
                System.out.print(merge[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int end = intervals[0][1];
        List<Integer> segment = new ArrayList<>();
        segment.add(intervals[0][0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                segment.add(end);
                resultList.add(new ArrayList<>(segment));
                segment.clear();
                segment.add(intervals[i][0]);
                end = intervals[i][1];
            }
        }
        segment.add(end);
        resultList.add(new ArrayList<>(segment));

        int[][] resultArr = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i][0] = resultList.get(i).get(0);
            resultArr[i][1] = resultList.get(i).get(1);
        }
        return resultArr;
    }

}
