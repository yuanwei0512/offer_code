package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/19 16:38
 * Description：TODO
 */
public class Main268 {

    public int missingNumber(int[] nums) {
        int miss = nums.length;
        for (int i = 0; i < nums.length; i++) {
            miss ^= i ^ nums[i];
        }
        return miss;
    }

}
