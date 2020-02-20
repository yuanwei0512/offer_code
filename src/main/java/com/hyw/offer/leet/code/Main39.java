package com.hyw.offer.leet.code;

import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/19 17:10
 * Description：TODO
 */
public class Main39 {

    private LinkedList<Integer> segment = new LinkedList<>();
    private List<List<Integer>> resultList = new ArrayList<>();


    public void getSegment(int[] candidates, int target, int start) {

        if (target == 0) {
            resultList.add(new ArrayList<>(segment));
        } else if (target < 0){
            return;
        }
        for (int i = start; i < candidates.length && (target -candidates[i] >= 0); i++) {

            segment.add(candidates[i]);
            getSegment(candidates, target - candidates[i], i);
            segment.removeLast();
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        getSegment(candidates, target, 0);
        return resultList;
    }

    public static void main(String[] args) {
        Main39 main39 = new Main39();
        int[] nums = {2,3,6,7};
        System.out.println(main39.combinationSum(nums, 7));
        StringBuilder s = new StringBuilder("123");
    }

}
