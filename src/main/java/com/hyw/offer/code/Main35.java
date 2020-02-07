package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/5 16:21
 * Description：TODO
 */
public class Main35 {

    public static void main(String[] args) {

        RandomListNode randomListNode1 = new RandomListNode(1);
        RandomListNode randomListNode2 = new RandomListNode(2);
        RandomListNode randomListNode3 = new RandomListNode(3);
        RandomListNode randomListNode4 = new RandomListNode(4);
        RandomListNode randomListNode5 = new RandomListNode(5);

        randomListNode1.next = randomListNode2;
        randomListNode1.random = randomListNode3;

        randomListNode2.next = randomListNode3;
        randomListNode2.random = randomListNode5;

        randomListNode3.next = randomListNode4;

        randomListNode4.next = randomListNode5;
        randomListNode4.random = randomListNode2;


        Main35 main35 = new Main35();
        RandomListNode clone = main35.clone(randomListNode1);
        System.out.println("test");
    }

    public RandomListNode clone(RandomListNode pHead) {

        //1、赋值一个 N'
        RandomListNode temp = pHead;
        while (temp != null) {
            RandomListNode orignNext = temp.next;
            temp.next = new RandomListNode(temp.label);
            temp.next.next = orignNext;
            temp = orignNext;
        }

        //2、对N'的 random 链接进行赋值。
        temp = pHead;
        while (temp != null) {
            RandomListNode copyNode = temp.next;
            if (temp.random != null) {
                copyNode.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        //3、拆分出N'

        temp = pHead.next;
        RandomListNode resultNode = temp;
        while (temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return resultNode;

    }


    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

    }
}
