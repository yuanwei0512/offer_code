package com.hyw.offer.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/7 14:43
 * Description：TODO
 */
public class Main40 {

    public static void main(String[] args) {
        Main40 main40 = new Main40();
        int[] nums = {6, 5, 4, 9, 3, 1, 2, 5};
        main40.getLeastNumbersSolution(nums, 4);

    }

    public void getLeastNumbersSolution(int[] nums, int k) {
        MaxHeap maxHeap = new MaxHeap(k);
        for (int num : nums) {
            maxHeap.insert(num);
        }
        maxHeap.printDate();
    }

    final class MaxHeap {
        private int[] data;
        private int count;
        private int catacity;

        public MaxHeap(int catacity) {
            this.catacity = catacity;
            data = new int[catacity + 1];
        }


        public void insert(int num) {


            if (count == catacity) {
                //当插入的数比堆的最大值还大时直接丢弃
                if (num > data[1]) {
                    return;
                } else {
                    data[1] = num;
                    shiftDouwn();
                }
            } else {
                data[++count] = num;
                shiftUp();
            }


        }

        public void printDate() {
            for (int i = 1; i < data.length; i++) {
                System.out.print(data[i] + "  ");
            }

        }

        private void shiftDouwn() {

            int k = 1;
            while (k * 2 <= count) {
                //获取左孩子的index
                int j = k * 2;
                //比较左孩子大还是右孩子大
                if (j + 1 <= count && data[j] < data[j + 1]) {
                    j++;
                }
                //判断大的孩子是否比当前节点还要大
               /* if (this.data[k] >= this.data[j]){
                    break;
                }*/
                int temp = this.data[k];
                this.data[k] = data[j];
                data[j] = temp;
                k = j;

            }
        }

        private void shiftUp() {
            int k = this.count;

            while (k > 1 && data[k] > data[k>>2]) {
                int temp = data[k];
                data[k] = data[k/2];
                data[k/2] = temp;
                k /= 2;
            }
        }
    }

}
