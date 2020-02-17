package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/16 16:55
 * Description：TODO
 */
public class Main112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum - root.val;
        if (sum == 0) {
            if ((root.left == null && root.right == null)) {
                return true;
            }
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
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
