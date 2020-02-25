package com.hyw.offer.leet.code;

import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/20 15:44
 * Description：TODO
 */
public class Main90 {

    private List<List<Integer>> resultList = new ArrayList<>();
    private LinkedList<Integer> segment = new LinkedList<>();


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        resultList.add(new ArrayList<>());
        getSegment(nums, 0);
        return resultList;
    }

    private void getSegment(int[] nums, int index) {
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            segment.add(nums[i]);
            resultList.add(new ArrayList<>(segment));
            getSegment(nums, i + 1);
            segment.removeLast();
        }
    }

    public static void main(String[] args) {
        Main90 main90 = new Main90();
        int[] nums = {1, 2, 2};
        System.out.println(main90.subsetsWithDup(nums));
    }

}
