package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/17 14:45
 * Description：TODO
 */
public class Main189 {

    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 1) {
            return;
        }
        int n = nums.length;
        int temp = 0;
        for (int i = 0; i < n / 2; i++) {
            temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }

        for (int i = 0; i < (k / 2); i++) {
            temp = nums[i];
            nums[i] = nums[k - i - 1];
            nums[k - i - 1] = temp;
        }

        for (int i = 0; i < (n - k) / 2; i++) {
            temp = nums[i + k];
            nums[i + k] = nums[n - i - 1];
            nums[n - i - 1] =temp;
        }
    }


    public static void main(String[] args) {
        Main189 main189 = new Main189();
        int[] nums = {1,2,3,4,5,6,7};
        main189.rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");

        }
    }

}
