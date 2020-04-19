package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/13 16:22
 * Description：TODO
 */
public class Main15 {

    public static void main(String[] args) {
        Main15 main15 = new Main15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(main15.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        int n = nums.length;
        int sum;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            sum = 0 - nums[i];
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    resultList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return resultList;

    }

}
