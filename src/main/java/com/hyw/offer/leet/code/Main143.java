package com.hyw.offer.leet.code;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Project：study_996     @author yuanwei
 * DateTime：2020/4/20 16:42
 * Description：TODO
 */
public class Main143 {

    public static void main(String[] args) {
        Main143 main143 = new Main143();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        main143.reorderList(node1);
    }

    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = null;
            deque.add(temp);
        }
        ListNode sentry = new ListNode(-1);
        ListNode tail = sentry;
        while (true) {
            if (deque.size() == 0) {
                break;
            }
            tail.next = deque.pollFirst();
            tail = tail.next;

            if (deque.size() == 0) {
                break;
            }
            tail.next = deque.pollLast();
            tail = tail.next;
        }
        head = sentry.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
