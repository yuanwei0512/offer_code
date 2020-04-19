package com.hyw.offer.leet.code;

import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/30 17:37
 * Description：TODO
 */
public class Main581 {

    public static void main(String[] args) {
        Main581 main581 = new Main581();
        int[] nums = {1, 2, 3, 3, 3};
        System.out.println(main581.findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

}
