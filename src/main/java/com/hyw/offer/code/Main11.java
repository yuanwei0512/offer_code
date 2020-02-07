package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/2 13:55
 * Description：TODO
 */
public class Main11 {

    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int l = 0, h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < nums[h]) {
                h = mid;
            } else {
                l = mid;
            }
        }
        return nums[l];
    }
}
