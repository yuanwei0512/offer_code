package com.hyw.offer.leet.code;

import javax.swing.tree.TreeNode;
import java.util.TreeMap;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/16 15:22
 * Description：TODO
 */
public class Main226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
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
