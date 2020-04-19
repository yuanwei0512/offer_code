package com.hyw.offer.leet.code;

import java.util.Arrays;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/24 15:37
 * Description：TODO
 */
public class Main289 {

    public static void main(String[] args) {
        Main289 main289 = new Main289();
        int[][] nums = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        main289.gameOfLife(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println();
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }

        }
    }

    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        int n = board.length;
        int m = board[0].length;
        int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int[][] result = new int[board.length][board[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int liveCount = 0;
                for (int k = 0; k < direct.length; k++) {
                    int y = i + direct[k][0];
                    int x = j + direct[k][1];
                    if (validate(x, y, n, m)) {
                        if (board[y][x] == 1) {
                            liveCount++;
                        }
                    }
                }
                if (liveCount < 2 || liveCount > 3) {
                    result[i][j] = 0;
                } else if (liveCount == 3) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = board[i][j];
                }

            }
        }

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.copyOf(result[i], m);
        }

    }

    private boolean validate(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
