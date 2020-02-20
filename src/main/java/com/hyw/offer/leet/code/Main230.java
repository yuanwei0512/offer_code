package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/17 22:37
 * Description：TODO
 */
public class Main230 {

    private int nums;

    private List<TreeNode> inOrder(TreeNode node, List<TreeNode> list){
        if (node != null) {
            inOrder(node.left, list);
            list.add(node);
            inOrder(node.right, list);
        }
        return list;
    }

    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);

        return list.get(k - 1).val;

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
