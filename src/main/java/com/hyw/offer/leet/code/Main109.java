package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author yuanwei
 * DateTime：2020/4/20 17:01
 * Description：TODO
 */
public class Main109 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Main109 main109 = new Main109();
        TreeNode treeNode = main109.sortedListToBST(node1);
        System.out.println(treeNode);
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode cur = head;
        int n = -1;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int[] nums = new int[n + 1];
        cur = head;
        for (int i = 0; i <= n; i++) {
            nums[i] = cur.val;
            cur = cur.next;
        }
        return tryBuildTry(nums, 0, n);
    }

    private TreeNode tryBuildTry(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = (left + right) >> 1;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = tryBuildTry(nums, left, mid - 1);
        treeNode.right = tryBuildTry(nums, mid + 1, right);
        return treeNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
