package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/16 15:36
 * Description：TODO
 */
public class Main100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null ||p.val != q.val) {
            return false;
        }
        boolean leftFlag = true;
        boolean rigtFlag = true;

        if (p.left != null || q.left != null) {
            leftFlag = isSameTree(p.left, q.left);
        }
        if (p.right != null || q.right != null) {
            rigtFlag = isSameTree(p.right, q.right);
        }
        return leftFlag && rigtFlag;

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
