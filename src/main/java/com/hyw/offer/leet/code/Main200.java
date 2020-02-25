package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/24 14:53
 * Description：TODO
 */
public class Main200 {

    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visiable;
    private int x;
    private int y;


    private boolean valideFile(int newY, int newX) {
        if (newX < 0 || newX > x || newY < 0 || newY > y) {
            return false;
        }
        return true;
    }

    private void dfs(char[][] grid, int y, int x) {
        visiable[y][x] = true;
        for (int i = 0; i < direction.length; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (valideFile(newY, newX) && !visiable[newY][newX] && grid[newY][newX] == 1) {
                dfs(grid, newY, newX);
            }
        }
    }

    public int numIslands(char[][] grid) {
        this.x = grid[0].length - 1;
        this.y = grid.length - 1;
        visiable = new boolean[grid.length][grid[0].length];

        int result = 0;
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                if (grid[i][j] == 1 && !visiable[i][j]) {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Main200 main200 = new Main200();
        char[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.println(main200.numIslands(grid));
    }

}
