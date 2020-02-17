package com.hyw.offer.leet.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/9 22:32
 * Description：TODO
 */
public class Main283 {


    public static void main(String[] args) {
        Main283 main283 = new Main283();
        int[] nums = {0, 1, 0, 3, 1, 2};
        System.out.println(main283.moveZeroes2(nums));
    }


    /**
     * 时间复杂度为 0(n)
     */
    public List<Integer> moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int i = 0;
        int temp = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }

        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    /**
     * 时间复杂度为 0(n * n)
     */
    public List<Integer> moveZeroes1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        int temp = 0;
        a:
        for (int i = 1; i < nums.length; i++) {
            b:
            for (int j = i; j > 0; j--) {
                if (nums[j] == 0) {
                    break b;
                }
                if (nums[j - 1] == 0) {
                    temp = nums[j ];
                    nums[j ] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return Arrays.stream(nums).boxed().collect(Collectors.toList());

    }

}
