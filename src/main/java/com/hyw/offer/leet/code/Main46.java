package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/18 16:50
 * Description：TODO
 */
public class Main46 {

    private LinkedList<Integer> segment = new LinkedList<>();
    private boolean[] flag;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        flag = new boolean[nums.length];
        List<List<Integer>> resultList = new ArrayList<>();
        tryPermute(nums, resultList);
        return resultList;
    }

    private void tryPermute(int[] nums, List<List<Integer>> resultList) {

        if (segment.size() == nums.length) {
            resultList.add(new ArrayList<>(segment));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                segment.add(nums[i]);
                tryPermute(nums, resultList);
                segment.removeLast();
                flag[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Main46 main46 = new Main46();
        int[] nums = {1, 2, 3};
        System.out.println(main46.permute(nums));
    }

}
