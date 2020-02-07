package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/6 10:23
 * Description：TODO
 */
public class Main13 {


    private static final int[][]next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int rows;
    private int cols;
    private int threshold;
    private int allowPath;
    //计算每个 xy对应的值
    private int[][] digitSum;

    public int movingCount(int threshold, int rows, int cols) {
        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        initDigitSum(rows, cols);
        //用于回溯算法中这个点十分有走动过
        boolean[][] marked = new boolean[rows][ cols];
        dfc(marked, 0, 0);
        return allowPath;
    }

    private void dfc(boolean[][] marked, int r, int c) {
        //当不满足要求时返回
        if (r <0 || r > rows || c < 0 || c > cols || marked[r][c]) {
            return;
        }
        marked[r][c] = true;
        //当大于阀值时返回
        if (this.digitSum[r][c] > threshold) {
            return;
        }
        //当前点满足要求
        allowPath++;
        //接着遍历上下左右四个点
        for (int[] n : next) {
            dfc(marked, r + n[0], c + n[1]);
        }
    }

    private void initDigitSum(int rows, int cols) {
        int[] digSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digSumOne.length; i++) {
            int n = i;
            while (n > 0) {
                digSumOne[i] += n % 10;
                n = n / 10;
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                this.digitSum[r][c] = digSumOne[r] + digSumOne[c];
            }
        }

    }

}
