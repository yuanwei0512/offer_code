package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/12 16:27
 * Description：TODO
 */
public class Main543 {

    private int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 1;
        }
        deep(root);
        return maxDiameter - 1;
    }

    private int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDeep = deep(root.left);
        int rightDeep = deep(root.right);
        maxDiameter = Math.max(maxDiameter, leftDeep + rightDeep + 1);
        return Math.max(leftDeep, rightDeep) + 1;

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
