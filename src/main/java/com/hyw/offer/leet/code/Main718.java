package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/4 16:26
 * Description：TODO
 */
public class Main718 {

    private int[] nums1;
    private int[] nums2;

    private int[][] memory;

    /*public int findLength(int[] a, int[] b) {

        
    }*/

    /**
     *          nums1 = a;
     *         nums2 = b;
     *         return tryFindLength(a.length - 1, b.length - 1);
     */
    private int tryFindLength(int index1, int index2) {

        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (memory[index1][index2] != 0) {
            return memory[index1][index2];
        }
        if (nums1[index1] == nums2[index2]) {
            memory[index1][index2] = tryFindLength(index1 - 1, index2 - 1) + 1;
            return memory[index1][index2];
        } else {
            memory[index1][index2] = Math.max(tryFindLength(index1 - 1, index2), tryFindLength(index1, index2 - 1));
            return memory[index1][index2];
        }
    }

    public static void main(String[] args) {
        Main718 main = new Main718();
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};

    }

}
