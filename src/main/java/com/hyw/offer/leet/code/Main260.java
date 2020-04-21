package com.hyw.offer.leet.code;

import java.util.HashSet;
import java.util.Set;

/**
 * Project：study_996     @author yuanwei
 * DateTime：2020/4/20 19:50
 * Description：TODO
 */
public class Main260 {

    public static void main(String[] args) {
        Main260 main260 = new Main260();
        int[] nums = {1,2,1,3,2,5};
        int[] ints = main260.singleNumber(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        Object[] objects = set.toArray();
        int[] result = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            result[i] = (int) objects[i];
        }
        return result;
    }

}
