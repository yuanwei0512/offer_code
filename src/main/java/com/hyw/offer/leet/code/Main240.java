package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/15 15:44
 * Description：TODO
 */
public class Main240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }


        int row = 0;
        int column = matrix[0].length - 1;

        while (row <= matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            }
            if (matrix[row][column] < target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }



}
