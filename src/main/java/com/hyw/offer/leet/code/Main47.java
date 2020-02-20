package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/19 16:00
 * Description：TODO
 */
public class Main47 {

    private List<List<Integer>> resultList = new ArrayList<>();
    private LinkedList<Integer> segment = new LinkedList<>();
    private boolean[] flag;

    private void permuteUnique(int[] nums, int index) {

        if (index == nums.length) {
            resultList.add(new ArrayList<>(segment));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            segment.add(nums[i]);
            permuteUnique(nums, index + 1);
            flag[i] = false;
            segment.removeLast();

        }


    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        flag = new boolean[nums.length];
        permuteUnique(nums, 0);
        return resultList;
    }

    public static void main(String[] args) {
        Main47 main47 = new Main47();
        int[] nums = {1, 1, 2};
        System.out.println(main47.permuteUnique(nums));
    }

}
