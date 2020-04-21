package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/14 21:50
 * Description：TODO
 */
public class Main83 {

    public static void main(String[] args) {
        Main83 main83 = new Main83();
        ListNode node1 = new ListNode(1);
        ListNode node2 = main83.createHead(2);
        ListNode node3 = main83.createHead(2);
        ListNode node4 = main83.createHead(3);
        ListNode node5 = main83.createHead(3);
        node1.next = node2;
        node1.next = node3;
        node3.next = node4;
        node4.next = node5;
        main83.deleteDuplicates(node1);
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sentry = new ListNode(head.val);
        ListNode tail = sentry;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val != tail.val) {
                tail.next = cur;
                tail = tail.next;

            }
            cur = cur.next;
        }
        tail.next = null;
        return sentry;

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
