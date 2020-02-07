package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/2 9:15
 * Description：TODO
 */
public class Main8 {

    public TreeLinkNode getInParent(TreeLinkNode node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            TreeLinkNode parent = node.parent;
            if (parent.left == node) {
                return parent;
            }
            node = parent;
        }
        return null; 
    }

    public static class TreeLinkNode {
        private int val;
        private TreeLinkNode left;
        private TreeLinkNode right;
        private TreeLinkNode parent;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }

}
