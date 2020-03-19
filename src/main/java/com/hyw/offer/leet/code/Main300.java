package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/3 16:10
 * Description：TODO
 */
public class Main300 {

    private int[] memory;

    public int lengthOfLIS(int[] nums) {
        int[] memory = new int[nums.length];
        for (int i = 0; i < memory.length; i++) {
            memory[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memory[i] = Math.max(memory[i], memory[j] + 1);
                }
            }
        }
        int maxResult = 0;
        for (int i = 0; i < memory.length; i++) {
            maxResult = Math.max(memory[i], maxResult);
        }
        return maxResult;
    }


    /**
     *      if (nums == null || nums.length == 0) {
     *             return 0;
     *         }
     *
     *         memory = new int[nums.length];
     *         for (int i = 0; i < nums.length; i++) {
     *             memory[i] = 1;
     *         }
     *         tryLengthOfLIS(nums, nums.length - 1);
     *         int result = 0;
     *         for (int i : memory) {
     *             result = Math.max(result, i);
     *         }
     *         return result;
     */
    private int tryLengthOfLIS(int[] nums, int index) {
        if (index == 0) {
            return 1;
        }
        if (memory[index] != 1) {
            return memory[index];
        }
        int res = 0;
        for (int i = 0; i < index; i++) {
            int x = tryLengthOfLIS(nums, i);
            if (nums[i] < nums[index]) {
                res = Math.max(res, x);
            }
        }
        return memory[index] = res + 1;
    }

    public static void main(String[] args) {
        Main300 main300 = new Main300();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(main300.lengthOfLIS(nums));
    }

}
