package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/31 13:25
 * Description：TODO
 */
public class Main3 {

    public static boolean duplicate(int[] nums, int length) {
        if (nums == null || nums.length <= 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {

            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    System.out.println(nums[i]);
                    return true;
                } else {
                    swap(nums, nums[i], nums[nums[i]]);
                }
            }

        }
        return false;

    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5};
        duplicate(nums, nums.length);
    }

}
