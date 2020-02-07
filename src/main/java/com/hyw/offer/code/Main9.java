package com.hyw.offer.code;

import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/31 14:58
 * Description：用两个栈实现队列
 */
public class Main9 {

    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);

    }

    public int pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) {
            throw new Exception("queue is empty");
        }

        return out.pop();

    }

}
