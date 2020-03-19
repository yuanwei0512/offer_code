package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/12 15:11
 * Description：TODO
 */
public class Main36 {

    public boolean isValidSudoku(char[][] board) {

        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] columns = new HashSet[9];;
        Set<Integer>[] boxs = new HashSet[9];;
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxs[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }
                int n = (int)num;
                int boxNum = j % 3 + i % 3 * 3;
                if (rows[j].contains(n) || columns[j].contains(n) || boxs[boxNum].contains(n)) {
                    return false;
                } else {
                    rows[j].add(n);
                    columns[j].add(n);
                    boxs[boxNum].add(n);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
