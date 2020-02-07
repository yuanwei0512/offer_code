package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/6 14:46
 * Description：TODO
 */
public class Main36 {

    private TreeNode head;
    private TreeNode preNode;

    public TreeNode convert(TreeNode root) {

        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        //设置头指针
        if (head == null) {
            head = node;
        }
        node.left = preNode;
        if (preNode != null) {
            preNode.right = node;
        }
        preNode = node;

        inOrder(node.right);

    }


    public static void main(String[] args) {

        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode14 = new TreeNode(14);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode16 = new TreeNode(16);

        treeNode10.setLeft(treeNode6);
        treeNode10.setRight(treeNode14);
        treeNode6.setLeft(treeNode4);
        treeNode6.setRight(treeNode8);
        treeNode14.setLeft(treeNode12);
        treeNode14.setRight(treeNode16);

        Main36 main36 = new Main36();

        main36.convert(treeNode10);

        System.out.println("test");
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
