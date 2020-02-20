package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/17 15:32
 * Description：TODO
 */
public class Main129 {

    private void getPathNums(List<Integer> resultNums, TreeNode root, int value) {
        value = value * 10 + root.val;
        if (root.left == null && root.right == null) {
            resultNums.add(value);
        } else {
            if (root.left != null) {
                getPathNums(resultNums, root.left, value);
            }
            if (root.right != null) {
                getPathNums(resultNums, root.right, value);
            }
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> pathNumsList = new ArrayList<>();
        getPathNums(pathNumsList, root, 0);
        int sum = 0;
        for (Integer integer : pathNumsList) {
            sum += integer;
        }
        return sum;
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
