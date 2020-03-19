package com.hyw.offer.leet.code;

import com.hyw.offer.leet.code.Main445.ListNode;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/17 15:39
 * Description：TODO
 */
public class Main206 {

    public ListNode reverseList(ListNode head) {

        ListNode sentry = new ListNode(-1);
        ListNode cur = head;
        ListNode next;
        ListNode temp;
        while (cur != null) {
            next = sentry.next;
            temp = cur;
            cur = cur.next;
            temp.next = null;
            sentry.next = temp;
            sentry.next.next = next;
        }
        return sentry.next;
    }

    public static void main(String[] args) {
        Main206 main206 = new Main206();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = main206.reverseList(node1);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
