package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author yuanwei
 * DateTime：2020/4/20 16:33
 * Description：TODO
 */
public class Main74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int y = matrix.length;
        int x = matrix[0].length;

        int width = x - 1;
        int top = 0;

        while (width >= 0 && top < y) {
            if (matrix[top][width] == target) {
                return true;
            } else if (matrix[top][width] < target) {
                top++;
            } else {
                width--;
            }
        }
        return false;

    }

}
