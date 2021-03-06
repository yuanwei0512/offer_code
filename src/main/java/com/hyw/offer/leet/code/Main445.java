package com.hyw.offer.leet.code;

import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/15 15:18
 * Description：TODO
 */
public class Main445 {

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        ListNode listNode44 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode5 = new ListNode(5);
        listNode44.next = listNode6;
        listNode6.next = listNode5;

        Main445 main2 = new Main445();
        main2.printNode(main2.addTwoNumbers(listNode3, listNode44));

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = new ListNode(0);
        ListNode headAfter = head;
        Stack<ListNode> lastNodes = new Stack<>();
        lastNodes.push(headAfter);
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = (x + y);

            ListNode newNode = new ListNode(sum % 10);

            headAfter.next = newNode;
            headAfter = headAfter.next;

            if (sum >= 10) {
                lastNodes.pop().val++;
            } else {
                lastNodes.pop();
            }
            lastNodes.push(newNode);
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        return head.next;
    }


    /**
     * 输出答应节点
     */
    public void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * @param n 节点个数
     * @return 创建顺序节点
     */
    public ListNode createHead(int n) {
        ListNode head = new ListNode(-1);
        ListNode last = head;
        for (int i = 1; i <= n; i++) {
            ListNode listNode = new ListNode(i);
            last.next = listNode;
            last = listNode;
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
