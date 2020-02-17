package com.hyw.offer.leet.code;

import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/15 16:57
 * Description：TODO
 */
public class Main150 {

    public static void main(String[] args) {
        Main150 main150 = new Main150();
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(main150.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer pop1;
        Integer pop2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    stack.push(pop2 + pop1);
                    break;
                case "-":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    stack.push(pop2 - pop1);
                    break;
                case "*":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    stack.push(pop2 * pop1);
                    break;
                case "/":
                    pop1 = stack.pop();
                    pop2 = stack.pop();
                    stack.push(pop2 / pop1);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

}
