package com.hyw.offer.leet.code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/11 16:18
 * Description：TODO
 */
public class Main324 {

    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);

        int r = (nums.length - 1 >> 1) + 1 ;
        int l = 1;
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) {
                nums[i] = nums2[r++];
            } else {
                nums[i] = nums2[l++];
            }
        }

        

    }

    public static void main(String[] args) {
        Main324 main324 = new Main324();
        int[] nums = {1,1,2,1,2,2,1};
        main324.wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }


}
