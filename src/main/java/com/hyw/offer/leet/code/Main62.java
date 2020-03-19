package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/26 16:51
 * Description：TODO
 */
public class Main62 {

    private int[][] memory;
    private int m;
    private int n;

    public int uniquePaths(int m, int n) {
        int[][] memory = new int[m][n];
        for (int i = 0; i < n; i++) {
            memory[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            memory[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memory[i][j] = memory[i - 1][j] + memory[i][j - 1];
            }
        }
        return memory[m - 1][n - 1];


    }

    private boolean validFild(int x, int y) {
        if (x >= 0 && x <= n && y >= 0 && y <= m) {
            return true;
        }
        return false;
    }

    /**
     * this.memory = new int[m][n];
     * this.m = m - 1;
     * this.n = n - 1;
     * <p>
     * return uniquePath(0, 0);
     *
     * @param x
     * @param y
     * @return
     */
    private int uniquePath(int x, int y) {
        if (x == n && y == m) {
            return 1;
        }

        if (memory[y][x] != 0) {
            return memory[y][x];
        }

        int sum = 0;
        if (validFild(x + 1, y)) {
            sum += uniquePath(x + 1, y);
        }
        if (validFild(x, y + 1)) {
            sum += uniquePath(x, y + 1);
        }

        memory[y][x] = sum;
        return sum;

    }


    public static void main(String[] args) {
        Main62 main62 = new Main62();
        System.out.println(main62.uniquePaths(7, 3));
    }

}
