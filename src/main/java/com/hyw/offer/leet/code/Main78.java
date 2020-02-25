package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/20 15:37
 * Description：TODO
 */
public class Main78 {

    private List<List<Integer>> resultList = new ArrayList<>();
    private LinkedList<Integer> segment = new LinkedList<>();

    public void getSegment(int[] nums, int index) {

        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            segment.add(nums[i]);
            resultList.add(new ArrayList<>(segment));
            getSegment(nums, i + 1);
            segment.removeLast();
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        resultList.add(new ArrayList<>());
        getSegment(nums, 0);
        return resultList;
    }

    public static void main(String[] args) {
        Main78 main78 = new Main78();
        int[] nums = {1, 2, 3};
        System.out.println(main78.subsets(nums));
    }
}
