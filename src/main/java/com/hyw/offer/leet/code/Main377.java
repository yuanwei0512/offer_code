package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/1 16:52
 * Description：TODO
 */
public class Main377 {


    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] memory = new int[target + 1];
        int n = nums.length;
        memory[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] <= i) {
                    memory[i] += memory[i - nums[j]];
                }
            }
        }
        return memory[target];
    }

    public static void main(String[] args) {


        Main377 main377 = new Main377();
        int[] nums = {1, 2, 3};
        System.out.println(main377.combinationSum4(nums, 4));
    }

}
