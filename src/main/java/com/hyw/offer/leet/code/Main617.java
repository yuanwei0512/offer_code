package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/12 16:10
 * Description：TODO
 */
public class Main617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        return tryMergeTree(t1, t2);

    }

    private TreeNode tryMergeTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            t1.left = tryMergeTree(t1.left, t2.left);
            t1.right = tryMergeTree(t1.right, t2.right);
            return t1;
        } else if (t1 == null) {
            t2.left = tryMergeTree(null, t2.left);
            t2.right = tryMergeTree(null, t2.right);
            return t2;
        } else {
            t1.left = tryMergeTree(t1.left, null);
            t1.right = tryMergeTree(t1.right, null);
            return t1;
        }

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
