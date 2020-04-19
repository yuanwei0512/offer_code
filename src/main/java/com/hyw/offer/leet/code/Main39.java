package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/19 17:10
 * Description：TODO
 */
public class Main39 {

    private LinkedList<Integer> segment = new LinkedList<>();
    private List<List<Integer>> resultList = new ArrayList<>();


    public static void main(String[] args) {
        Main39 main39 = new Main39();
        int[] nums = {8, 7, 4, 3};
        System.out.println(main39.combinationSum(nums, 11));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        getSegment(candidates, target, 0);
        return resultList;
    }

    private void getSegment(int[] candidates, int target, int start) {

        if (target == 0) {
            resultList.add(new ArrayList<>(segment));
        } else if (target < 0){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                continue;
            }
            segment.add(candidates[i]);
            getSegment(candidates, target - candidates[i], i);
            segment.removeLast();
        }

    }

}
