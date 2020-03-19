package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/3 15:21
 * Description：TODO
 */
public class Main494 {



    public int findTargetSumWays(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return tryFindTargetSumWays(nums, s, 0);

    }

    private int tryFindTargetSumWays(int[] nums, int s, int index) {
        if (index == nums.length) {
            if (s == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int sum = 0;
        sum += tryFindTargetSumWays(nums, s + nums[index], index + 1);
        sum += tryFindTargetSumWays(nums, s - nums[index], index + 1);

        return sum;
    }

    public static void main(String[] args) {
        Main494 main494 = new Main494();
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(main494.findTargetSumWays(nums, 3));
    }

}
