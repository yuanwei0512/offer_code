package com.hyw.offer.code;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/8 16:45
 * Description：TODO
 */
public class Main59 {

    public static void main(String[] args) {
        Main59 main59 = new Main59();
        int[] nums = {2,3,4,2,6,2,5,1};
        System.out.println(main59.maxInWindows(nums, 3));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> resultList = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            queue.add(num[i]);
        }
        resultList.add(queue.peek());

        for (int i = 0, j = size; j < num.length; i++, j++) {
            queue.remove(num[i]);
            queue.add(num[j]);
            resultList.add(queue.peek());
        }
        return resultList;

    }

}
