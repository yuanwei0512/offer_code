package com.hyw.offer.leet.code;

import java.util.Arrays;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/20 15:51
 * Description：TODO
 */
public class Main169 {

    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];

    }

}
