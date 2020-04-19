package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/29 15:36
 * Description：TODO
 */
public class Main59 {

    public static void main(String[] args) {
        Main59 main59 = new Main59();
        int[][] nums = main59.generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.print(nums[i][j] + " ");
            }

        }
    }

    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int button = n - 1;
        int count = 0;
        int[][] nums = new int[n][n];

        while (left <= right && top <= button) {
            for (int i = left; i <= right; i++) {
                nums[top][i] = ++count;
            }
            top++;
            for (int i = top; i <= button; i++) {
                nums[i][right] = ++count;
            }
            right--;
            for (int i = right; i >= left; i--) {
                nums[button][i] = ++count;
            }
            button--;
            for (int i = button; i >= top; i--) {
                nums[i][left] = ++count;
            }
            left++;
        }
        return nums;
    }

}
