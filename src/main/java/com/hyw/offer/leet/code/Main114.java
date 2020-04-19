package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/7 16:13
 * Description：TODO
 */
public class Main114 {

    public static void main(String[] args) {
        Main114 main114 = new Main114();
        TreeNode node1 = new TreeNode(1);
        /*TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;*/
        main114.flatten(node1);
        System.out.println("aa");
    }

    /*public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            tryFlatten(root);
            cur = cur.right;
        }

    }*/

    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

    private TreeNode tryFlatten(TreeNode node) {
        TreeNode leftNode = node.left;
        if (node.left != null && node.left.left != null) {
            leftNode = tryFlatten(node.left);
        }
        TreeNode rightNode = node.right;
        node.right = leftNode;

        TreeNode cur = node;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = rightNode;
        node.left = null;
        return node;
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
