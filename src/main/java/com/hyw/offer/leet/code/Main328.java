package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/15 15:18
 * Description：TODO
 */
public class Main328 {

    public static void main(String[] args) {
        Main328 main328 = new Main328();
        ListNode head = main328.createHead(5);
        main328.printNode(head);
        head = main328.oddEvenList(head);
        main328.printNode(head);
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode odd_Node = new ListNode(0);
        ListNode odd = odd_Node;
        ListNode even_Node = new ListNode(0);
        ListNode even = even_Node;

        while (head != null) {
            if (head.val % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
        }
        even.next = null;
        odd.next = even_Node.next;
        return odd_Node.next;

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
