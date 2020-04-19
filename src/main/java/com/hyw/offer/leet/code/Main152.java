package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/20 14:45
 * Description：TODO
 */
public class Main152 {

    public static void main(String[] args) {
        Main152 main152 = new Main152();
        int[] nums = {2, 3, -2, 4};
        System.out.println(main152.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int imax = 1;
        int imin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                imax = Math.max(nums[i], imax * nums[i]);
                imin = Math.min(nums[i], imin * nums[i]);
            } else {
                int temp = imax;
                imax = imin;
                imin = temp;
                imax = Math.max(nums[i], imax * nums[i]);
                imin = Math.min(nums[i], imin * nums[i]);
            }
            max = Math.max(imax, max);
        }
        return max;

    }

}
