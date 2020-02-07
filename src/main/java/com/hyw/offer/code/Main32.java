package com.hyw.offer.code;

import com.hyw.offer.code.Main26.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/1 16:04
 * Description：TODO
 */
public class Main32 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode11 = new TreeNode(11);

        root1.left = treeNode6;
        root1.right = treeNode10;
        treeNode6.left = treeNode5;
        treeNode6.right = treeNode7;
        treeNode10.left = treeNode9;
        treeNode10.right = treeNode11;

        Main32 main32 = new Main32();
        ArrayList<Integer> resultList = main32.printFromTopToBottom(root1);
        System.out.println(resultList);
    }


    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            int currentSize = nodeQueue.size();
            while (currentSize-- > 0) {
                TreeNode node = nodeQueue.poll();
                //当节点为空时跳过
                if (null == node) {
                    continue;
                }
                resultList.add(node.value);
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
            }


        }
        return resultList;
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
