package com.hyw.offer.leet.code;

import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/27 15:08
 * Description：TODO
 */
public class Main105 {

    private int[] preorder;
    private int[] inorder;
    private boolean[] flag;

    public static void main(String[] args) {
        Main105 main105 = new Main105();
        int[] preOrder = {7, -10, -4, 3, -1, 2, -8, 11};
        int[] inOrder = {-4, -10, 3, -1, 7, 11, -8, 2};

        TreeNode treeNode = main105.buildTree(preOrder, inOrder);
        System.out.println(main105.levelOrder(treeNode));
        System.out.println(main105.inorderTraversal(treeNode));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        flag = new boolean[preorder.length];
        return tryBuildTree(0, 0, inorder.length - 1);
    }

    private TreeNode tryBuildTree(int preIndex, int start, int end) {
        if (preIndex == preorder.length) {
            return null;
        }
        for (int i = start; i <= end; i++) {
            if (inorder[i] == preorder[preIndex]) {
                TreeNode root = new TreeNode(preorder[preIndex]);
                flag[preIndex] = true;
                root.left = tryBuildTree(preIndex + 1, start, i - 1);
                if (root.left == null) {
                    root.right = tryBuildTree(preIndex + 1, i + 1, end);
                } else {
                    for (int j = preIndex + 1; j < inorder.length; j++) {
                        if (!flag[j]) {
                            root.right = tryBuildTree(j, i + 1, end);
                            break;
                        }

                    }
                }
                return root;
            }
        }
        return null;

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> resultList = new ArrayList<>();
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> segment = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                segment.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            resultList.add(segment);
        }
        return resultList;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        tryInorderTraversal(root, result);
        return result;
    }

    private List<Integer> tryInorderTraversal(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return resultList;
        }
        tryInorderTraversal(root.left, resultList);
        resultList.add(root.val);
        tryInorderTraversal(root.right, resultList);
        return resultList;
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
