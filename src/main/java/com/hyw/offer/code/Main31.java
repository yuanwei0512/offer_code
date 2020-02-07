package com.hyw.offer.code;

import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/3 15:49
 * Description：TODO
 */
public class Main31 {

    public static void main(String[] args) {
        Main31 main31 = new Main31();
        int[] pushSequence = {1,2,3,4,5};
        int[] popSequence = {3,2,4,5,1};
        System.out.println(main31.isPopOrder(pushSequence, popSequence));
    }

    public boolean isPopOrder(int[] pushSequence, int[] popSequence) {

        Stack<Integer> stack = new Stack<>();
        int length = pushSequence.length;
        for (int pushIndex = 0, popIndex = 0; pushIndex < length; pushIndex++) {
            stack.push(pushSequence[pushIndex]);

            while (popIndex < length && !stack.empty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }

        }
        return stack.isEmpty();
    }

}
