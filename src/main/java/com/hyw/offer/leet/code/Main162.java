package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/25 15:15
 * Description：TODO
 */
public class Main162 {

    public static void main(String[] args) {
        Main162 main162 = new Main162();
        int[] nums = {1, 2, 3, 1};
        System.out.println(main162.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

}
