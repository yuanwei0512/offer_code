package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/1 16:04
 * Description：TODO
 */
public class Main26 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode77 = new TreeNode(7);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode77;
        treeNode8.left = treeNode9;
        treeNode8.right = treeNode2;
        root1.left = treeNode8;
        root1.right = treeNode7;

        TreeNode root2 = new TreeNode(8);
        TreeNode treeNode99 = new TreeNode(9);
        TreeNode treeNode22 = new TreeNode(2);
        root2.left = treeNode99;
        root2.right = treeNode22;

        Main26 main = new Main26();
        System.out.println(main.hasSubtree(root1, root2));
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtreeWithRoot(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root2.right, root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (null == root2) {
            return true;
        }
        if (null == root1) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);

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
