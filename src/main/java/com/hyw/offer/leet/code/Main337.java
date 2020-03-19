package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/28 14:45
 * Description：TODO
 */
public class Main337 {

    private Map<TreeNode, Integer> memory;

    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;

    }

    /**
     *          if (root == null) {
     *             return 0;
     *         }
     *         memory = new HashMap<>();
     *         return tryRob(root);
     */
    private int tryRob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memory.get(root) != null) {
            return memory.get(root);
        }

        int fatherValue = root.val;
        if (root.left != null) {
            fatherValue += tryRob(root.left.left) + tryRob(root.left.right);
        }
        if (root.right != null) {
            fatherValue += tryRob(root.right.left) + tryRob(root.right.right);
        }

        int childValue = 0;
        if (root.left != null) {
            childValue +=tryRob(root.left);
        }
        if (root.right != null) {
            childValue +=tryRob(root.right);
        }
        int max = Math.max(fatherValue, childValue);
        memory.put(root, max);
        return max;

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
