package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/21 15:22
 * Description：TODO
 */
public class Main236 {

    private TreeNode result;

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;
        Main236 main236 = new Main236();
        TreeNode treeNode = main236.lowestCommonAncestor(treeNode3, treeNode5, treeNode4);
        System.out.println(treeNode.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        getParent(root, p, q);
        return result;
    }

    private boolean getParent(TreeNode treeNode, TreeNode p, TreeNode q) {

        if (treeNode == null) {
            return false;
        }
        if (treeNode == p || treeNode == q) {
            result = treeNode;
            return true;
        }
        boolean left = getParent(treeNode.left, p, q);
        boolean right = getParent(treeNode.right, p, q);
        if (left && right) {
            result = treeNode;
            return true;
        }
        return left || right;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
