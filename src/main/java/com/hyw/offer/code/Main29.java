package com.hyw.offer.code;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/2 15:21
 * Description：TODO
 */
public class Main29 {

    public static void main(String[] args) {

        int[][] nums =  {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
        Main29 main29 = new Main29();
        List<Integer> resultList = main29.printMatrix(nums);
        System.out.println(resultList);
    }

    public List<Integer> printMatrix(int[][] matrix) {

        List<Integer> resultList = new ArrayList<>();

        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1 ;

        while (r1 <= r2 && c1 <= c2) {

            for (int i = c1; i <= c2; i++) {
                resultList.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                resultList.add(matrix[i][c2]);
            }
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1 ; i--) {
                    resultList.add(matrix[r2][i]);
                }
            }
            if (c1 != c2) {
                for (int i = r2 - 1; i >= r2 ; i--) {
                    resultList.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return resultList;
    }

}
