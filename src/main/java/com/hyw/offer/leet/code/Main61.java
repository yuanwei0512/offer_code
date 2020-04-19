package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/29 16:02
 * Description：TODO
 */
public class Main61 {

    public static void main(String[] args) {
        Main61 main61 = new Main61();
        ListNode listNode1 = new ListNode(1);

        ListNode listNode = main61.rotateRight(listNode1, 1);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return head;
        }
        int count = 0;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        count++;
        k = k % count;
        if (k == 0) {
            return head;
        }
        ListNode lastNode = cur;
        cur = head;
        for (int i = 0; i < count - k; i++) {

            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        lastNode.next = head;
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
