package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/22 15:42
 * Description：TODO
 */
public class Main378 {

    public static void main(String[] args) {

    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (right - left) / 2;
            int count = findNotBiggerThanMid(matrix, mid, n);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int n) {
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < n || j >= 0) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }

}
