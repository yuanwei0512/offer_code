package com.hyw.offer.code;

import com.hyw.offer.leet.code.Main445.ListNode;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/7 16:33
 * Description：TODO
 */
public class Main52 {

    /**
     * @param headA
     * @param headB
     * @return
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            if (tempA.next == null) {
                tempA = headB;
                continue;
            }
            if (tempB.next == null) {
                tempB = headA;
                continue;
            }

            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
