package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/31 13:48
 * Description：选取左上角和右下角其他是没差别的
 */
public class Main4 {

    public boolean find(int targe, int[][]matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = 0;
        int c = cols - 1;

        while (r < rows && c > 0) {
            if (matrix[r][c] == targe) {
                System.out.println(targe);
                return true;
            } else if (matrix[r][c] > targe) {
                c++;
            } else {
                r++;
            }

        }
        return false;
    }

}
