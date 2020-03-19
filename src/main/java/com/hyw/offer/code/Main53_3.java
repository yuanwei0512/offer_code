package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/8 14:56
 * Description：TODO
 */
public class Main53_3 {

    public static void main(String[] args) {
        Main53_3 main53_3 = new Main53_3();
        int[] nums = {-3, -1, 1, 3, 5};
        System.out.println(main53_3.getNumberSameAsIndex(nums));
    }

    public int getNumberSameAsIndex(int[] nums) {
        int l = 0;
        int r = nums.length;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == mid) {
                return mid;
            }

            if (nums[mid] < mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }


        return -1;
    }

}
