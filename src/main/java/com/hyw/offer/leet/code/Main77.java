package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/19 16:43
 * Description：TODO
 */
public class Main77 {

    private LinkedList<Integer> segment = new LinkedList<>();
    private List<List<Integer>> resultList = new ArrayList<>();

    private void combine(int n, int k, int start) {
        if (segment.size() == k) {
            resultList.add(new ArrayList<>(segment));
        }

        for (int i = start; i <= n; i++) {

            segment.add(i);
            combine(n, k, i + 1);
            segment.removeLast();
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return Collections.emptyList();
        }
        combine(n, k, 1);
        return resultList;
    }

    public static void main(String[] args) {
        Main77 main77 = new Main77();
        System.out.println(main77.combine(4, 2));
    }

}
