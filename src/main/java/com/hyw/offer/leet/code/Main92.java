package com.hyw.offer.leet.code;

import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/14 21:06
 * Description：TODO
 */
public class Main92 {

    public static void main(String[] args) {


        Main92 main92 = new Main92();
        ListNode head = main92.createHead(5);
        main92.printNode(head);
        head = main92.reverseBetween(head, 2, 4);
        main92.printNode(head);
    }



    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = head;
        int i = 1;
        for (; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode last = pre.next;
        ListNode cur = pre.next.next;
        ListNode next = cur.next;
        for (; i < n - 1; i++) {
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
            next = next.next;
        }
        last.next = cur;
        return head;
    }

    /**
     *  输出答应节点
     */
    public void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    /**
     *
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
