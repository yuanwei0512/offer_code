package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/8 14:56
 * Description：TODO
 */
public class Main53_2 {

    public static void main(String[] args) {
        Main53_2 main53_2 = new Main53_2();
        int[] nums = {0, 1, 2, 3, 3, 5, 6, 7, 8};
        System.out.println(main53_2.getMissgingNumberber(nums));
    }

    public int getMissgingNumberber(int[] nums) {
        int l = 0;
        int r = nums.length;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] != mid) {
                if (nums[mid -1] == mid -1) {
                    return mid;
                }

                r = mid - 1;

            } else {
                l = mid + 1;
            }
        }

        if (l == nums.length) {
            return l;
        }

        return -1;
    }

}
