package com.hyw.offer.leet.code;

import com.hyw.offer.leet.code.Main445.ListNode;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/13 15:01
 * Description：TODO
 */
public class Main148 {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }


        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        ListNode cur;
        ListNode pre;


        int len = getListLen(head);
        for (int i = 1; i < len; i<<=1) {
            pre = sentry;
            cur = sentry.next;

            while (cur != null) {
                ListNode left = cur;
                ListNode right = slipListNode(left, i);
                cur = slipListNode(right, i);
                pre.next = merge(left, right);
                while (pre.next != null) {
                    pre = pre.next;
                }
            }

        }
        return sentry.next;
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode sentry = new ListNode(-1);
        ListNode cur = sentry;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;

            }
            cur = cur.next;
        }

        while (left != null) {
            cur.next = left;
            left = left.next;
            cur = cur.next;
        }
        while (right != null) {
            cur.next = right;
            right = right.next;
            cur = cur.next;
        }
        return sentry.next;

    }

    /**
     *
     * @param head 链表
     * @param step 指定步长
     * @return 返回指定长度的链表  并切断后续
     */
    private ListNode slipListNode(ListNode head, int step) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        for (int i = 1; i < step && cur.next != null; i++) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        return next;
    }

    /**
     *
     * @return 获取链表长度
     */
    private int getListLen (ListNode head) {

        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Main148 main148 = new Main148();
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = main148.sortList(node1);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }


}
