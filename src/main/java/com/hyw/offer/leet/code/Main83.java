package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/14 21:50
 * Description：TODO
 */
public class Main83 {

    public static void main(String[] args) {
        Main83 main83 = new Main83();
        ListNode listNode = new ListNode(1);
        ListNode head = main83.createHead(5);
        listNode.next = head;
        head = listNode;
        main83.printNode(head);
        head = main83.deleteDuplicates(head);
        main83.printNode(head);
    }


    public ListNode deleteDuplicates(ListNode head) {
        while (head.next != null && head.val ==head.next.val) {
            head = head.next;
        }
        ListNode pre = head;
        ListNode next = pre.next;
        while (next.next != null) {
            while (next.val == next.next.val) {
                next = next.next;
            }
            pre.next = next;
            pre = next;
            next = next.next;
        }
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
