package com.hyw.offer.leet.code;

import java.util.*;

import static java.util.Comparator.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/15 21:58
 * Description：TODO
 */
public class Main347 {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        Main347 main347 = new Main347();
        System.out.println(main347.topKFrequent(nums, 2));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequncyMap = new HashMap<>();

        for (int num : nums) {
            frequncyMap.merge(num, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : frequncyMap.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<Integer> topK = new ArrayList<>();
        while (!queue.isEmpty()) {
            topK.add(queue.poll().getKey());
        }
        Collections.reverse(topK);
        return topK;

    }

}
