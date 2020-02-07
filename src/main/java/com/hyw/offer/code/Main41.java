package com.hyw.offer.code;

import java.util.PriorityQueue;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/7 16:43
 * Description：TODO
 */
public class Main41 {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int n = 0;

    public void insert(Integer val) {
        if (n % 2 == 0 ) {
            minHeap.add(val);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(val);
            minHeap.add(maxHeap.poll());
        }
        n++;

    }
    public Double GetMedian() {
        if (n % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else {
            return (double) minHeap.peek();
        }
    }
    public static void main(String[] args) {


    }



}
