package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/7 17:24
 * Description：TODO
 */
public class Mian42 {

    public int findGreatestSumOfSubArray(int[] nums) {
        if (nums == null ||nums.length < 0) {
            return -1;
        }
        int result = 0;
        int sum = 0;
        for (int num : nums) {
            sum = sum < 0 ? 0 : sum + num;
            result = Math.max(result, sum);
        }
        return result;
    }

}
