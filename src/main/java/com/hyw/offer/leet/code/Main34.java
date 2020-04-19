package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/25 15:36
 * Description：TODO
 */
public class Main34 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Main34 main34 = new Main34();
        System.out.println(main34.searchRange(nums, 1));
    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int index = Integer.MIN_VALUE;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (index == Integer.MIN_VALUE) {
            return new int[]{-1, 1};
        }

        int left = index;
        int right = index;
        while (left - 1 >= 0 && nums[left - 1] == nums[index]) {
            left--;
        }
        while (right + 1 < nums.length && nums[right + 1] == nums[index]) {
            right++;
        }
        return new int[]{left, right};
    }

}
