package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/17 16:09
 * Description：TODO
 */
public class Main437 {


    public int pathSum(TreeNode root, int sum) {
        int count = 0;
        if (root == null) {
            return count;
        }
        if (sum == root.val) {
            count++;
        }
        if (root.left != null) {
            count += pathSum(root.left, sum - root.val);
            count += pathSum(root.left, sum);
        }
        if (root.right != null) {
            count += pathSum(root.right, sum - root.val);
            count += pathSum(root.right, sum);
        }

        return count;

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
