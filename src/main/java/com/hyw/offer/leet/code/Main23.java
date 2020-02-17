package com.hyw.offer.leet.code;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/15 22:48
 * Description：TODO
 */
public class Main23 {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = new ListNode(0);
        ListNode last = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            queue.offer(list);
        }
        while (!queue.isEmpty()) {
            ListNode p = queue.poll();
            last.next = p;
            last = last.next;
            if (p.next != null) {
                queue.offer(p);
            }
        }
        return head.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
