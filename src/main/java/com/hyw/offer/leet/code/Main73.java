package com.hyw.offer.leet.code;

import java.util.HashSet;
import java.util.Set;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/14 15:17
 * Description：TODO
 */
public class Main73 {

    public void setZeroes(int[][] matrix) {

        boolean rowFlag = false;
        boolean colFlag = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][i] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowFlag) {
            for (int i = 0; i < matrix[0].length; i++) {
               matrix[0][i] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }


        /**
         * 空间复杂度为 m + n
         */
        /*if (matrix == null ||matrix.length == 0) {
            return;
        }
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (Integer column : columns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
        for (Integer row : rows) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }*/
    }


    public static void main(String[] args) {
        Main73 main73 = new Main73();
        int[][] nums = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        main73.setZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println();
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + "  ");
            }
        }

    }

}
