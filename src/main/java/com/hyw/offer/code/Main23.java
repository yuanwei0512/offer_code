package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/1/30 15:32
 * Description：TODO
 */
public class Main23 {

    public static void main(String[] args) {

        Main23.Node node1 = new Main23.Node(1);
        Main23.Node node2 = new Main23.Node(2);
        Main23.Node node3 = new Main23.Node(3);
        Main23.Node node4 = new Main23.Node(4);
        Main23.Node node5 = new Main23.Node(5);
        Main23.Node node6 = new Main23.Node(6);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node3);


        Main23 main23 = new Main23();
        System.out.println(main23.entryNodeOfLoop(node1));
    }


    public Node entryNodeOfLoop(Node pHead) {
        // 1、两个指针， 一个一次走一步，一个一次走两步，两个指针会在环内遇到。
        Node fast = pHead;
        Node show = pHead;
        do {
            fast = fast.next.next;
            show = show.next;
        } while (fast != show);

        // 2、其中一个指针再次开始一次走一步，并记录，当两个指针再次相遇时就可知道环的大小。
        int loopSize = 0;
        do {
            show = show.next;
            loopSize++;
        } while (fast != show);


        // 3、一个指针从头开始， 一指针从环的大小位置开始，当两个节点相遇时就是环的入口。
        fast = pHead;
        show = pHead;
        for (int i = 0; i < loopSize; i++) {
            fast = fast.next;
        }
        do {
            fast = fast.next;
            show = show.next;
        } while (fast != show);

        return fast;


    }


    public static class Node{

        private int value;
        private Main23.Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Main23.Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Main23.Node getNext() {
            return next;
        }

        public void setNext(Main23.Node next) {
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
