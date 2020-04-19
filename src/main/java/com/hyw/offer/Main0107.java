package com.hyw.offer;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/7 14:47
 * Description：TODO
 */
public class Main0107 {

    public static void main(String[] args) {
        Main0107 main0107 = new Main0107();
        int[][] nums = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        main0107.rotate(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println();
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + "  ");
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;
        for (int x = 0; x < n / 2; x++) {
            for (int y = 0; y < n; y++) {
                temp = matrix[y][x];
                matrix[y][x] = matrix[y][n - x - 1];
                matrix[y][n - x - 1] = temp;
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n - y; x++) {
                temp = matrix[y][x];
                matrix[y][x] = matrix[n - x - 1][n - y - 1];
                matrix[n - x - 1][n - y - 1] = temp;
            }
        }
    }

}
