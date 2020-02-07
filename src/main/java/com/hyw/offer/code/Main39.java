package com.hyw.offer.code;

import java.util.Arrays;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/6 22:11
 * Description：TODO
 */
public class Main39 {

    public static void main(String[] args) {

        Main39 main39 = new Main39();
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(main39.moreThanHalfNumSolution(nums));

    }


    /**
     * @return 推荐
     */
    public int moreThanHalfNumSolution(int[] nums) {

        if (nums == null && nums.length == 0) {
            return -1;
        }

        int majority = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            } else if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : nums) {
            if (num == majority) {
                count++;
            }
        }
        return count < nums.length>>1 ? -1 : majority;
    }



    private int partition(int[] nums, int left, int right) {

        int v = nums[left];
        int j = left;
        int temp;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > v) {
                temp = nums[i];
                nums[i] = nums[j+1];
                nums[j+1] = temp;
                j++;
            }
        }

        temp = nums[j];
        nums[j] = nums[left];
        nums[left] = temp;
        return j;
    }

}
