package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/4 15:04
 * Description：TODO
 */
public class Main376 {


    /**
     *      if (nums == null || nums.length == 0) {
     *             return 0;
     *         }
     *         if (nums.length == 1) {
     *             return 1;
     *         }
     *         int[] memory = new int[nums.length];
     *         int[] flag = new int[nums.length];
     *
     *         int n = nums.length;
     *
     *
     *         for (int i = 1; i < n; i++) {
     *             for (int j = 0; j < i; j++) {
     *                 if (j == 0) {
     *                     memory[i] = 2;
     *                     if (nums[j] < nums[i]) {
     *                         flag[i] = 1;
     *                     } else {
     *                         flag[i] = 0;
     *                     }
     *                 }
     *                 if (nums[j] < nums[i] && flag[j] == 0) {
     *                     memory[i] = Math.max(memory[i], memory[j] + 1);
     *                     flag[i] = 1;
     *                 } else if (nums[j] > nums[i] && flag[j] == 1) {
     *                     memory[i] = Math.max(memory[i], memory[j] + 1);
     *                     flag[i] = 0;
     *                 }
     *             }
     *         }
     *         return memory[nums.length - 1];
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                } else if (nums[j] < nums[i]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);

    }

    public static void main(String[] args) {
        Main376 main376 = new Main376();
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        main376.wiggleMaxLength(nums);
    }


}
