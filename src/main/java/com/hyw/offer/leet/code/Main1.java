package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/13 15:51
 * Description：TODO
 */
public class Main1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> lackMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = lackMap.get(nums[i]);
            if (index != null) {
                result[0] = index;
                result[1] = i;
                return result;
            }
            lackMap.put(target - nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        Main1 main1 = new Main1();
        int[] nums = {2, 7, 11, 15};
        int[] result = main1.twoSum(nums, 22);
        System.out.println(result[0] + "   " + result[1]);
    }
}
