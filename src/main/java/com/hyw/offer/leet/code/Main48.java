package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/17 14:02
 * Description：TODO
 */
public class Main48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1 + i; j < n - i; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[n - i - 1][j];
                int temp2 = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
                temp = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp2;
                matrix[n - i - 1][j] = temp;
            }
        }



    }

    public static void main(String[] args) {
        Main48 main48 = new Main48();
        int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        main48.rotate(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

}
