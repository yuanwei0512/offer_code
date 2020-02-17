package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/10 15:07
 * Description：TODO
 */
public class Main88 {

    public void mergeNums(int[] nums1, int[] nums2, int n1Last, int n2Last) {
        int i = n1Last;
        int j = n2Last;

        for (int k = nums1.length - 1; k > 0; k--) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums1[i];
                j--;
            }
        }

    }

    public static void main(String[] args) {

    }
}
