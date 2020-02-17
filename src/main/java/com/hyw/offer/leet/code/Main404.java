package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/16 17:33
 * Description：TODO
 */
public class Main404 {

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (isLeafNode(root.left)) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    private boolean isLeafNode(TreeNode node) {
        if (node != null && node.left != null && node.right != null) {
            return true;
        }
        return false;
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
