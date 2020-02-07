package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/30 15:32
 * Description：TODO
 */
public class Main22 {

    public static void main(String[] args) {
        Main22.Node node1 = new Main22.Node(1);
        Main22.Node node2 = new Main22.Node(2);
        Main22.Node node3 = new Main22.Node(3);
        Main22.Node node4 = new Main22.Node(4);
        Main22.Node node5 = new Main22.Node(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        Node head = new Node(-1);
        head.setNext(node1);

        Main22 main22 = new Main22();
        main22.findKthToTail(head, 2);
    }


    public void findKthToTail(Node head, int k) {

        if (head == null){
            return;
        }

        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        System.out.println(p2.value);
    }

    public static class Node{

        private int value;
        private Main22.Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Main22.Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Main22.Node getNext() {
            return next;
        }

        public void setNext(Main22.Node next) {
            this.next = next;
        }
    }
}
