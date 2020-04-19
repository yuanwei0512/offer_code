package com.hyw.offer.leet.code;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/22 16:33
 * Description：TODO
 */
public class Main215 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        Main215 main215 = new Main215();
        System.out.println(main215.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
