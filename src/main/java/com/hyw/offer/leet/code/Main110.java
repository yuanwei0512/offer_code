package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/16 16:20
 * Description：TODO
 */
public class Main110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return Math.abs(leftDepth - rightDepth) < 2 && isBalanced(root.left) && isBalanced(root.right);


    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }


        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;

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
