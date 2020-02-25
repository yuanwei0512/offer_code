package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/20 15:23
 * Description：TODO
 */
public class Main216 {

    private List<List<Integer>> resultList = new ArrayList<>();
    private LinkedList<Integer> segment = new LinkedList<>();

    private void combinationSum3(int k, int index, int n, int target) {

        if (segment.size() == k) {
            if (target == 0) {
                resultList.add(new ArrayList<>(segment));
            }
            return;
        }

        for (int i = index; i < n && i <= target; i++) {
            segment.add(i);
            combinationSum3(k, i + 1, n, target - i);
            segment.removeLast();
        }

    }

    /**
     * @param k 个数
     * @param n 0~n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 1 || n < 1 || k > n) {
            return Collections.emptyList();
        }
        combinationSum3(k, 1, n, n);
        return resultList;
    }

    public static void main(String[] args) {
        Main216 main216 = new Main216();
        System.out.println(main216.combinationSum3(3, 9));
    }

}
