package com.hyw.offer.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/5 15:45
 * Description：TODO
 */
public class Main34 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node12 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        root.left = node5;
        root.right = node12;
        node5.left = node4;
        node5.right = node7;

        Main34 main = new Main34();
        List<List<Integer>> path = main.findPath(root, 22);
        System.out.println(path);

    }

    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode root, int target, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }
        path.add(root.value);
        target -= root.value;
        if ((target == 0) && (root.left == null) && (root.right == null)) {
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(root.left, target, path);
            backtracking(root.right, target, path);
        }
        path.remove(path.size() - 1);
    }

    public static class TreeNode {

        private int value;
        private Main34.TreeNode left;
        private Main34.TreeNode right;

        public TreeNode(int value) {
            this(value, null, null);
        }

        public TreeNode(int value, Main34.TreeNode left, Main34.TreeNode right) {
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

        public Main34.TreeNode getLeft() {
            return left;
        }

        public void setLeft(Main34.TreeNode left) {
            this.left = left;
        }

        public Main34.TreeNode getRight() {
            return right;
        }

        public void setRight(Main34.TreeNode right) {
            this.right = right;
        }
    }

}
