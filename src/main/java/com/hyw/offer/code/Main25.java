package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/30 15:32
 * Description：TODO
 */
public class Main25 {

    public static void main(String[] args) {

        Main25.Node node1 = new Main25.Node(1);
        Main25.Node node2 = new Main25.Node(2);
        Main25.Node node3 = new Main25.Node(3);
        Main25.Node node4 = new Main25.Node(4);
        Main25.Node node5 = new Main25.Node(5);
        Main25.Node node6 = new Main25.Node(6);
        Main25.Node node7 = new Main25.Node(7);
        Main25.Node node8 = new Main25.Node(8);

        node1.setNext(node3);
        node3.setNext(node5);
        node5.setNext(node7);

        node2.setNext(node4);
        node4.setNext(node6);
        node6.setNext(node8);


        Main25 main25 = new Main25();
        Node node = main25.merge(node1, node2);
        while (node != null) {
            System.out.print(node.value + "  ");
            node = node.next;
        }
    }


    public Node merge(Node list1, Node list2) {


        Node node = new Node(-1);
        Node temp = node;

        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        while (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
        }

        while (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
        }
        return node;
    }



    public static class Node{

        private int value;
        private Main25.Node next;

        public Node(int value) {
            this(value, null);
        }

        public Node(int value, Main25.Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Main25.Node getNext() {
            return next;
        }

        public void setNext(Main25.Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
