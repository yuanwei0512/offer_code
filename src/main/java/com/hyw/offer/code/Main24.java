package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/30 15:32
 * Description：TODO
 */
public class Main24 {

    public static void main(String[] args) {

        Main24.Node node1 = new Main24.Node(1);
        Main24.Node node2 = new Main24.Node(2);
        Main24.Node node3 = new Main24.Node(3);
        Main24.Node node4 = new Main24.Node(4);
        Main24.Node node5 = new Main24.Node(5);
        Main24.Node node6 = new Main24.Node(6);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);



        Main24 main24 = new Main24();
        Node node = main24.reverseList(node1);
        while (node != null) {
            System.out.print(node.value + "  ");
            node = node.next;
        }
    }


    public Node reverseList(Node head) {

        Node temp = head;
        Node newList = new Node(-1);

        while (temp != null){
            Node next = temp.next;
            temp.next = newList.next;
            newList.next = temp;
            temp = next;

        }

        return newList;


    }



    public static class Node{

        private int value;
        private Main24.Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Main24.Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Main24.Node getNext() {
            return next;
        }

        public void setNext(Main24.Node next) {
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
