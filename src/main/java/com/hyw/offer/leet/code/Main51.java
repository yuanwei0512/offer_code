package com.hyw.offer.leet.code;

import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/24 20:29
 * Description：TODO
 */
public class Main51 {

    private List<String> result;
    private boolean[] dia;
    private boolean[] dia1;
    private boolean[] dia2;
    private LinkedList<Integer> segment;

    public List<String> solveNQueens(int n) {
        result = new ArrayList<>();
        dia = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        segment = new LinkedList<>();
        putQueen(n, 0);
        return result;
    }

    private void putQueen(int n, int index) {
        if (index == n) {
            generateBoard(n, segment);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!dia[i] && !dia1[i + index] && !dia2[i - index + n - 1]) {
                segment.add(i);
                dia[i] = true;
                dia1[i + index] = true;
                dia2[i - index + n - 1] = true;
                putQueen(n, index + 1);
                dia[i] = false;
                dia1[i + index] = false;
                dia2[i - index + n - 1] = false;
                segment.removeLast();
            }
        }
    }

    private void generateBoard(int n, List<Integer> segment) {
        assert  segment.size() == n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Integer index = segment.get(i);
            for (int j = 0; j < n; j++) {
                if (index == j) {
                    sb.append("Q   ");
                } else {
                    sb.append(".   ");
                }
            }
            sb.append("\n");
        }
        result.add(sb.toString());
    }

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
    }

}
