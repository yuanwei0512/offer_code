package com.hyw.offer.leet.code;

import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/15 15:18
 * Description：TODO
 */
public class Main82 {

    public static void main(String[] args) {
        Main82 main82 = new Main82();
        ListNode head = main82.createHead(8);
        main82.printNode(head);
        main82.printNode(main82.deleteDuplicates(head));

    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode next = dummyHead;
        while (true) {

            if ((head.val == head.next.val)) {
                while ((head.next != null) && head.val == head.next.val) {
                    head = head.next;
                }
                head = head.next;

            }
            next.next = head;
            next = head;
            if (head == null) {
                break;
            }
            head = head.next;
        }
        return dummyHead.next;
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
            if (i % 2 == 0) {
                ListNode listNode = new ListNode(i);
                last.next = listNode;
                last = listNode;
            }
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
