package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/13 16:50
 * Description：TODO
 */
public class Main136 {

    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = temp ^ nums[i];
        }
        return temp;
    }

}
