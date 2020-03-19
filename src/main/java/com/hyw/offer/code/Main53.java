package com.hyw.offer.code;




/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/7 17:23
 * Description：TODO
 */
public class Main53 {

    public int GetNumberOfK(int[] nums, int K) {
        int index = myBinarySearch(nums, K);
        int leftTemp =  index;
        int size = 0;
        while (nums[leftTemp] != K) {
            size++;
            leftTemp--;
        }

        int rightTemp = index + 1;
        while (nums[rightTemp] != K) {
            size++;
            rightTemp--;
        }
        return size;
    }

    private int myBinarySearch(int[] nums, int k) {

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int min = (l + r) / 2;
            if (nums[min] < k) {
                r = min;
            } else if (nums[min] > k) {
                l = min;
            } else {
                return min;
            }
        }
        return -1;
    }

}
