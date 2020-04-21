package com.hyw.offer.leet.code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/19 15:14
 * Description：TODO
 */
public class Main994 {

    private int count;

    private int[][] dirction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int[][] grid;

    private Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Main994 main994 = new Main994();
        int[][] nums = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(main994.orangesRotting(nums));
    }

    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int y = grid.length;
        int x = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == 2) {
                    int[] temp = {i, j};
                    queue.add(temp);
                }
            }
        }
        bfc(queue, 0);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    private void bfc(Queue<int[]> queue, int level) {
        count = Math.max(count, level);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] poll = queue.poll();
            for (int[] ints : dirction) {
                int newX = ints[0] + poll[1];
                int newY = ints[1] + poll[0];
                if (validate(newY, newX) && grid[newY][newX] == 1) {
                    grid[newY][newX] = 2;
                    int[] temp = {newY, newX};
                    queue.add(temp);
                }
            }
        }
        if (queue.size() > 0) {
            bfc(queue, level + 1);
        }

    }

    private boolean validate(int y, int x) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }

}
