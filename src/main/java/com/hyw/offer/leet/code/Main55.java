package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/22 16:46
 * Description：TODO
 */
public class Main55 {

    private int[] memory;

    public static void main(String[] args) {
        int[] nums = {3, 0, 8, 2, 0, 0, 1};
        Main55 main55 = new Main55();
        System.out.println(main55.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1 || nums[0] >= nums.length - 1) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {

            b:
            for (int j = nums[i]; j > 0; j--) {
                if (j + i >= n - 1 || dp[j + i]) {
                    dp[i] = true;
                    break b;
                }
            }
        }
        return dp[0];

    }

    /**
     * if (nums == null || nums.length == 0) {
     * return false;
     * }
     * <p>
     * // 1可以到达  2无法到达
     * memory = new int[nums.length];
     * return tryJump(nums, 0);
     */
    private boolean tryJump(int[] nums, int index) {
        if (memory[index] != 0) {
            return memory[index] == 1;
        }
        if (nums[index] >= nums.length - 1 - index) {
            memory[index] = 1;
            return true;
        }

        int cur = nums[index];
        if (cur == 0) {
            memory[index] = 2;
            return false;
        }
        boolean flag = false;
        for (int i = 1; i <= cur; i++) {
            if (tryJump(nums, index + i)) {
                flag = true;
                break;
            }
        }
        memory[index] = flag ? 1 : 2;
        return flag;
    }

}
