package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/19 14:59
 * Description：TODO
 */
public class Main234 {

    public static void main(String[] args) {
        Main234 main234 = new Main234();

        ListNode node1 = new ListNode(1);


        System.out.println(main234.isPalindrome(node1));
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode halfNode = getPreHalf(head);
        ListNode endHalf = reverse(halfNode.next);

        ListNode cur = head;

        while (endHalf != null) {
            if (cur.val != endHalf.val) {
                return false;
            }
            cur = cur.next;
            endHalf = endHalf.next;
        }
        return true;

    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode sentry = new ListNode(-1);

        while (cur != null) {
            ListNode next = sentry.next;
            sentry.next = cur;
            cur = cur.next;
            sentry.next.next = next;
        }
        return sentry.next;
    }

    private ListNode getPreHalf(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
