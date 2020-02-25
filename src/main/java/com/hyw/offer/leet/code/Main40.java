package com.hyw.offer.leet.code;

import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/20 14:52
 * Description：TODO
 */
public class Main40 {

    private List<List<Integer>> resultList = new ArrayList<>();
    private LinkedList<Integer> segment = new LinkedList<>();

    protected void getSegment(int[] candidates, int index, int target) {
        if (target == 0) {
            resultList.add(new ArrayList<>(segment));
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i] ) {
                continue;
            }

            // 小剪枝
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }



            segment.add(candidates[i]);
            getSegment(candidates, i + 1, target - candidates[i]);
            segment.removeLast();
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        getSegment(candidates, 0, target);
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        Main40 main40 = new Main40();
        List<List<Integer>> lists = main40.combinationSum2(nums, 8);
        System.out.println(lists);
    }


}
