package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/6 9:51
 * Description：TODO
 */
public class Main12 {

    private final static int[][] next ={{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;

        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtracking(matrix, str, marked, 0, r, c)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c) {

        if (pathLen == str.length) {
            return true;
        }

        if (r < 0 || r > rows || c < 0 || c > cols || matrix[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }

        marked[r][c] = true;
        for (int[] n : next) {
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }
        marked[r][c] = false;
        return false;

    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        int index = 0;
        for(int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = array[index++];
            }
        }
        return matrix;
    }

}
