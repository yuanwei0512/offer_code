package com.hyw.offer.leet.code;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/27 15:13
 * Description：TODO
 */
public class Main198 {

    private int[] memory;

    public static void main(String[] args) {
        Main198 main198 = new Main198();
        int[] nums = {2, 17, 9, 3, 17};

        System.out.println(main198.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] memory = new int[n];
        memory[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memory[i] = Math.max(memory[i], nums[j] + (j < n - 2 ? memory[j + 2] : 0));
            }
        }
        return memory[0];
    }

    /**
     * memory = new int[nums.length + 1];
     * return tryRob(nums, 0);
     */
    private int tryRob(int[] nums, int index) {

        if (index >= nums.length) {
            return 0;
        }

        if (memory[index] != 0) {
            return memory[index];
        }

        int res = Integer.MIN_VALUE;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memory[index] = res;
        return res;
    }

}
