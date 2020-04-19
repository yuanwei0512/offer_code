package com.hyw.offer.hightfrequency;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/6 19:27
 * Description：TODO
 */
public class MainTest {

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mainTest.merge(nums, 3, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m <= 0) {
                nums1[i] = nums2[n - 1];
                n--;
                continue;
            }
            if (n <= 0) {
                nums1[i] = nums1[m - 1];
                m--;
                continue;
            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }

    }

}
