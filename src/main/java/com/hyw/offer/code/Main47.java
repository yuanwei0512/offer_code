package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/6 16:17
 * Description：TODO
 */
public class Main47 {

    private int[][] direction = {{1, 0}, {0, 1}};

    private int maxValue;

    public static void main(String[] args) {
        Main47 main47 = new Main47();
        int[][] nums = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        System.out.println(main47.getMost(nums));
    }

    public int getMost(int[][] values) {

        int[] nums = new int[values[0].length];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                if (j == 0) {
                    nums[j] = nums[j] + values[i][j];
                } else {
                    nums[j] = Math.max(nums[j], nums[j - 1]) + values[i][j];
                }
            }
        }
        return nums[values[0].length - 1];

    }


    /**
     *          if (values.length == 0) {
     *             return 0;
     *         }
     *
     *
     *         tryGetMost(values, 0, 0, 0);
     *         return maxValue;
     */
    private void tryGetMost(int[][] values, int x, int y, int cur) {

        cur += values[y][x];
        if (x == values[0].length - 1 && y == values.length - 1) {
            maxValue = Math.max(maxValue, cur);
        }

        for (int i = 0; i < direction.length; i++) {

            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (validateFied(newX, newY, values)) {
                tryGetMost(values, newX, newY, cur);
            }

        }


    }

    private boolean validateFied(int x, int y, int[][] values) {
        if (x >= 0 && x < values[0].length && y >= 0 && y < values.length) {
            return true;
        }
        return false;
    }


}
