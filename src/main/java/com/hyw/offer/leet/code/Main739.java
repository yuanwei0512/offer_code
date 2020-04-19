package com.hyw.offer.leet.code;

import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/7 15:40
 * Description：TODO
 */
public class Main739 {

    public static void main(String[] args) {
        Main739 main739 = new Main739();
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = main739.dailyTemperatures(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "  ");
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }

}
