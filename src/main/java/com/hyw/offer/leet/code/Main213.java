package com.hyw.offer.leet.code;

import java.util.Arrays;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/27 16:32
 * Description：TODO
 */
public class Main213 {

    private int[] memory;

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        memory = new int[nums.length];
        int value1 = tryRob(Arrays.copyOfRange(nums, 0, nums.length - 1), 0);
        memory = new int[nums.length];
        int value2 = tryRob(Arrays.copyOfRange(nums, 1, nums.length), 0);
        return Math.max(value1, value2);
    }


    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (memory[index] != 0) {
            return memory[index];
        }

        int res = Integer.MIN_VALUE;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(nums[i] + tryRob(nums, i + 2), res);

        }
        memory[index] = res;
        return res;
    }

    public static void main(String[] args) {
        Main213 main213 = new Main213();
        int[] nums = {1, 20, 8, 2, 50, 8};
        System.out.println(main213.rob(nums));
    }
}
