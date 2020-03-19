package com.hyw.offer.code;

import java.util.Arrays;


public class Main61 {

    public static void main(String[] args) {
        Main61 main61 = new Main61();
        int[] nums = {0, 0, 1, 2, 5};
        System.out.println(main61.isContinuous(nums));
    }

    public boolean isContinuous(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            }
        }

        for (int i = zero; i < nums.length - 1; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            zero -= nums[i + 1] - nums[i] - 1;
        }
        return zero >= 0;
    }
}
