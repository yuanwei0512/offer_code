package com.hyw.offer.leet.code;

import java.util.Arrays;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/13 21:14
 * Description：TODO
 */
public class Main16 {

    public static void main(String[] args) {
        Main16 main16 = new Main16();
        int[] nums = {0,2,1,-3};
        System.out.println(main16.threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null && nums.length < 3) {
            return target;
        }
        Arrays.sort(nums);
        int closest =  Math.abs(nums[0] + nums[1] + nums[2] - target);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int abs = Math.abs(nums[i] + nums[l] + nums[r] - target);
                if (abs < closest) {
                    closest = abs;
                    result = nums[i] + nums[l] + nums[r];
                }
                if (nums[i] + nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;

    }

}
