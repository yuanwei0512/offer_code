package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/27 14:38
 * Description：TODO
 */
public class Main138 {

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node1;

        Main138 main138 = new Main138();
        Node newNode = main138.copyRandomList(node1);

    }

    public Node copyRandomList(Node head) {
        //key 原来节点--》value copy后的节点
        Map<Node, Node> nodeMap = new HashMap<>();
        Node sentry = new Node(-1);
        Node pre = sentry;
        Node cur = head;

        while (cur != null) {
            Node node = new Node(cur.val);
            nodeMap.put(cur, node);
            pre.next = node;
            pre = node;
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node copyNode = nodeMap.get(cur);
            Node randomNode = nodeMap.get(cur.random);
            copyNode.random = randomNode;
            cur = cur.next;
        }
        return sentry.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
