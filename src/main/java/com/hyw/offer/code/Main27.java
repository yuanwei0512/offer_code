package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/1 16:04
 * Description：TODO
 */
public class Main27 {

    public static void main(String[] args) {


    }


    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.value != node2.value) {
            return false;
        }
        return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
    }




    public void mirror(TreeNode root) {

        if (null == root) {
            return;
        }
        swap(root);
        mirror(root.left);
        mirror((root.right));

    }

    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }


    public static class TreeNode {

        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this(value, null, null);
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
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
