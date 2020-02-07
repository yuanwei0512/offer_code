package com.hyw.offer.code;

import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/3 15:39
 * Description：TODO
 */
public class Main30 {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void insert(Integer data) {
        dataStack.push(data);
        minStack.push(minStack.empty() ? data : Math.min(minStack.peek(), data));
    }

}
