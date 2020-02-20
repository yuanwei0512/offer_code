package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/17 15:11
 * Description：TODO
 */
public class Main113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> pathList = new ArrayList<>();
                pathList.add(root.val);
                resultList.add(pathList);

            }
            return resultList;
        }
        if (root.left != null) {
            List<List<Integer>> lists = pathSum(root.left, sum - root.val);
            for (List<Integer> list : lists) {
                list.add(0, root.val);
                resultList.add(list);
            }
        }
        if (root.right != null) {
            List<List<Integer>> lists = pathSum(root.right, sum - root.val);
            for (List<Integer> list : lists) {
                list.add(0, root.val);
                resultList.add(list);
            }
        }
        return resultList;

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
