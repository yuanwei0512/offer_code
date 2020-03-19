package com.hyw.offer.leet.code;

import java.util.HashMap;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/1 14:34
 * Description：TODO
 */
public class Main416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((1 & sum ) != 0) {
            return false;
        }
        sum = sum / 2;


        boolean[] memory = new boolean[sum + 1];
        for (int j = 0; j <= sum; j++) {
            if (nums[0] == j) {
                memory[j] = true;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                memory[j] = memory[j] ||  memory[j - nums[i]];

            }
        }

        return memory[sum];
    }

    public static void main(String[] args) {
        System.out.println(2 & (9 - 1));
        /*int[] nums = {1, 5, 11, 6};
        Main416 main416 = new Main416();
        System.out.println(main416.canPartition(nums));*/
    }

    /**
     *  tryPartition(nums, nums.length, sum);
     */
    private boolean tryPartition(int[] nums, int index, int sum) {

        if (sum == 0) {
            return true;
        }

        if (sum < 0 || index < 0) {
            return false;
        }

        return tryPartition(nums, index - 1, sum) || tryPartition(nums, index - 1, sum - nums[index]);

    }

}
