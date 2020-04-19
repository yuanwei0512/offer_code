package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/23 14:57
 * Description：TODO
 */
public class Main334 {

    public static void main(String[] args) {
        Main334 main334 = new Main334();
        int[] nums = {2, 1, 5, 0, 3};
        System.out.println(main334.increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int mid = Integer.MAX_VALUE;
        int small = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;

    }

}
