package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/18 14:43
 * Description：TODO
 */
public class Main238 {

    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;

    }

    public static void main(String[] args) {
        Main238 main238 = new Main238();
        int[] nums = {1, 2, 3, 4};
        int[] res = main238.productExceptSelf(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
