package com.hyw.offer.leet.code;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/17 16:42
 * Description：TODO
 */
public class Main98 {

    private void inOrder(List<Integer> nums, TreeNode root) {
        if (root != null) {
            inOrder(nums, root.left);
            nums.add(root.val);
            inOrder(nums, root.right);
        }
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(nums, root);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) >= nums.get(i)) {
                return false;
            }
        }
        return true;
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
