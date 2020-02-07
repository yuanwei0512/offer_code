package com.hyw.offer.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/31 14:25
 * Description：从尾到头答应列表
 */
public class Main6 {

    /**
     * 递归的方式
     */
    public List<Integer> printListFromTailToHead1(Node node){
        List<Integer> resultList = new ArrayList<>();

        if (node != null){
            List<Integer> subList = printListFromTailToHead1(node.next);
            resultList.addAll(subList);
        }

        return resultList;

    }

    /**
     * 链表头插法
     */
    public List<Integer> printListFromTailToHead2(Node node){
        Node head = new Node(-1, null);

        while (node != null) {
            Node currentNode = node;
            currentNode.next = head.next;
            head.next = currentNode;
            node = node.next;
        }
        List<Integer> resultList = new ArrayList<>();
        while (head.next != null) {
            resultList.add(head.value);
            head = head.next;
        }
        return resultList;
    }

    /**
     * 栈
     */
    public List<Integer> printListFromTailToHead3(Node node){
        Stack<Integer> stack = new Stack<>();
        while (node.next != null) {
            stack.push(node.next.value);
            node = node.next;
        }
        List<Integer> resultList = new ArrayList<>();
        while (!stack.empty()) {
            resultList.add(stack.pop());
        }
        return resultList;
    }


    public static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
