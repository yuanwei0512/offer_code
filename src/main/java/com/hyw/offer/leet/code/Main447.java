package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/14 15:24
 * Description：TODO
 */
public class Main447 {

    public static void main(String[] args) {
        Main447 main447 = new Main447();
        int[][] nums = {{0,0},{1,0},{2,0}};
        System.out.println(main447.numberOfBoomerangs(nums));
    }

    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> distanceMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            distanceMap.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                distanceMap.merge(distance, 1, Integer::sum);
            }
            for (Map.Entry<Integer, Integer> entry : distanceMap.entrySet()) {
                if (entry.getValue() >= 2) {
                    count += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }
        return count;
    }

}
