package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/20 16:21
 * Description：TODO
 */
public class Main79 {

    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int maxX;
    private int maxY;
    private boolean[][] flag;


    private boolean validateDirction(int x, int y) {
        if (x >= 0 && x <= maxX && y >= 0 && y <= maxY) {
            return true;
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int x, int y) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }

        if (word.charAt(index) == board[x][y]) {
            flag[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if (validateDirction(newX, newY) && !flag[newX][newY]) {
                    if (searchWord(board, word, index + 1, newX, newY)) {
                        return true;
                    }
                }
            }
            flag[x][y] = false;
        }
        return false;

    }


    public boolean exist(char[][] board, String word) {
        this.maxX = board.length - 1;
        this.maxY = board[0].length - 1;
        flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main79 main79 = new Main79();
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        System.out.println(main79.exist(board, "ABCCED"));
    }

}
