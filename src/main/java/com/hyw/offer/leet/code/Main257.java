package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/17 14:45
 * Description：TODO
 */
public class Main257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        if (root.left == null && root.right == null) {
            resultList.add(String.valueOf(root.val));
            return resultList;
        }
        if (root.left != null) {
            List<String> leftPath = binaryTreePaths(root.left);
            for (String s : leftPath) {
                resultList.add(root.val + "->" + s);
            }
        }
        if (root.right != null) {
            List<String> rightPath = binaryTreePaths(root.right);
            for (String s : rightPath) {
                resultList.add(root.val + "->" + s);
            }
        }
        return resultList;
    }

    /*public void constructPaths(TreeNode root, String path, List<String> pathList) {
        if (root == null) {
            return;
        } else {
            path += String.valueOf(root.val);
        }

        if (root.left == null && root.right == null) {
            pathList.add(path);
            return;
        }
        path += "->";
        constructPaths(root.left, path, pathList);
        constructPaths(root.right, path, pathList);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        constructPaths(root, "", resultList);
        return resultList;
    }*/



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
