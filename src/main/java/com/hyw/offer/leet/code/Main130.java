package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/24 15:38
 * Description：TODO
 */
public class Main130 {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int x;
    private int y;

    public void solve(char[][] board) {
        x = board[0].length - 1;
        y = board.length - 1;


        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                boolean isEdget = (i == 0 || i == y || j == 0 || j == x);
                if (isEdget && (board[i][j] == 'O')) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean valideFile(int newY, int newX) {
        if (newX < 0 || newX > x || newY < 0 || newY > y) {
            return false;
        }
        return true;
    }

    private void dfs(char[][] board, int y, int x) {

        if (valideFile(y, x) && board[y][x] == 'O') {
            board[y][x] = '#';
            for (int[] ints : direction) {
                dfs(board, y + ints[0], x + ints[1]);
            }
        }

    }

}
