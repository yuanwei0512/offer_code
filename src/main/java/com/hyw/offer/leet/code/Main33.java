package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/14 15:49
 * Description：TODO
 */
public class Main33 {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l)/ 2;
            if (nums[mid] == target) {
                return target;
            }

            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        Main33 main33 = new Main33();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(main33.search(nums, 2));
    }

}
