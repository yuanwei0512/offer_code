package com.hyw.offer.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/2 9:00
 * Description：TODO
 */
public class Main7 {

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < pre.length; i++) {
            map.put(pre[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int prel, int prer, int inl) {
        TreeNode treeNode = new TreeNode(pre[prel]);
        Integer inIndex = map.get(pre[prel]);
        int leftTreeSize = inIndex - inl;
        treeNode.left = reConstructBinaryTree(pre, prel + 1, prel + leftTreeSize, inl);
        treeNode.right = reConstructBinaryTree(pre, prel + leftTreeSize, prer, inl + leftTreeSize + 1);
        return treeNode;
    }


    public static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
