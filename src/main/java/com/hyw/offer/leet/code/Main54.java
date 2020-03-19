package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/12 16:48
 * Description：TODO
 */
public class Main54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int button = matrix.length - 1;
        int right = matrix[0].length - 1;
        int left = 0;
        List<Integer> resultList = new ArrayList<>();
        while (top <= button && left <= right) {
            for (int i = left; i <= right; i++) {
                resultList.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= button; i++) {
                resultList.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                resultList.add(matrix[button][i]);
            }
            button--;
            for (int i = button; i >= top; i--) {
                resultList.add(matrix[i][left]);
            }
            left++;
        }
        return resultList;
    }

    public static void main(String[] args) {
        Main54 main54 = new Main54();
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(main54.spiralOrder(nums));
    }


}
