package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/30 15:11
 * Description：TODO
 */
public class Main21 {

    public static void main(String[] args) {

        Main21 main21 = new Main21();
        int [] nums = {1, 2, 3, 4, 5, 6, 7};
        main21.reOrderArray2(nums);
        for (int num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }


    /**
     * 冒泡， 时间复杂度o(n^2), 空间复杂度 O（1）
     * @param nums
     */
    public void reOrderArray2(int[] nums) {

        int length = nums.length;

        int temp = 0;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (!isOdd(nums[j]) && isOdd(nums[j + 1])) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }


    }

    /**
     * 时间复杂度O（n）, 空间复杂度O（n）
     * @param nums
     */
    public void reOrderArray(int[] nums) {

        if (nums.length == 0) {
            return;
        }

        int oddSize = 0;
        for (int num : nums) {
            if (isOdd(num)) {
                oddSize++;
            }
        }

        int[] clone = nums.clone();
        int i = 0;
        int j = oddSize;
        for (int n = 0; n < clone.length; n++) {
            if (isOdd(clone[n])) {
                nums[i++] = clone[n];
            } else {
                nums[j++] = clone[n];
            }
        }


    }

    public boolean isOdd(int n) {
        return n % 2 == 1;
    }

}
