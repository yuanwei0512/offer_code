package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/20 14:31
 * Description：TODO
 */
public class Main53 {

    public static void main(String[] args) {
        Main53 main53 = new Main53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(main53.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int pre = nums[0];
        int max = pre;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }

}
