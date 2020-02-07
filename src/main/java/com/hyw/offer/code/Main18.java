package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/28 22:37
 * Description：TODO
 */
public class Main18 {



    public static void main(String[] args) {


        Node node1 = new Node(4);
        Node node2 = new Node(3);
        node2.setNext(node1);
        Node node3 = new Node(3);
        node3.setNext(node2);
        Node node4 = new Node(2);
        node4.setNext(node3);
        Node node5 = new Node(2);
        node5.setNext(node4);
        Node head = new Node(1);
        head.setNext(node5);


        deleteDuplication(head);
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }


    }

    public static Node deleteDuplication(Node pHead) {
        Node next = pHead.next;

        boolean flag = false;
        while (next != null) {
            if (pHead.value == next.value) {
                next.value = next.next.value;
                next.next = next.next.next;
                flag = true;
            }
            next = next.next;
        }

        if (null != pHead.next) {
            pHead.next = deleteDuplication(pHead.next);

            if (flag) {
                pHead = pHead.next;
            }
        }

        return pHead;

    }

    public static class Node{

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
