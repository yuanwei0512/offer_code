package com.hyw.offer.leet.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/10 16:57
 * Description：TODO
 */
public class Main167 {

    public static void main(String[] args) {
        Main167 main167 = new Main167();
        int[] nums = {1, 3, 4, 6, 7, 9, 11};
        System.out.println(main167.twoSum(nums, 13));
    }

    public List twoSum(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return Collections.emptyList();
        }
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return Arrays.asList(l + 1, r + 1);
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return Collections.emptyList();
    }

}
