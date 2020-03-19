package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/17 16:42
 * Description：TODO
 */
public class Main19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();

        ListNode cur = head;
        int i = 1;
        while (cur != null) {
            map.put(i++, cur);
            cur = cur.next;
        }
        i -= 1;
        ListNode pre = map.get(i - n);
        if (pre == null) {
            head = map.getOrDefault(i - n + 2, null);
        } else {
            pre.next = map.getOrDefault(i - n + 2, null);
        }
        return head;
    }

    public static void main(String[] args) {
        Main19 main19 = new Main19();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node = main19.removeNthFromEnd(node1, 2);
        while (node != null) {
            System.out.print(node.val + "  ");
            node = node.next;
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
