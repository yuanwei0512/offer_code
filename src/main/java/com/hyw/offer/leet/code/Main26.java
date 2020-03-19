package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/18 14:14
 * Description：TODO
 */
public class Main26 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Main26 main26 = new Main26();
        int[] nums = {1,1,2};
        System.out.println(main26.removeDuplicates(nums));

    }

}
