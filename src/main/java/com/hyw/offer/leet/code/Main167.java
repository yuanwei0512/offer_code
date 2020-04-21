package com.hyw.offer.leet.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/10 16:57
 * Description：TODO
 */
public class Main167 {

    public static void main(String[] args) {
        Main167 main167 = new Main167();
        int[] nums = {1, 3, 4, 6, 7, 9, 11};
        System.out.println(main167.twoSum(nums, 13));
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] result = new int[2];
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                result[0] = l + 1;
                result[1] = r + 1;
                break;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }

}
