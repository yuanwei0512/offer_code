package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/17 22:25
 * Description：TODO
 */
public class Main108 {

    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null && nums.length == 0) {
            return null;
        }
        this.nums = nums;
        TreeNode treeNode = sortedArrayToBST(0, nums.length - 1);
        return treeNode;
    }

    private TreeNode sortedArrayToBST(int l, int r) {

        if (l > r) {
            return null;
        }

        int min = (r + l) /2;
        TreeNode treeNode = new TreeNode(nums[min]);
        treeNode.left = sortedArrayToBST(l, min - 1);
        treeNode.right = sortedArrayToBST(min + 1, r);
        return treeNode;
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
