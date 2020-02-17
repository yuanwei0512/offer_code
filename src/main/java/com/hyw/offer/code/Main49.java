package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/8 21:43
 * Description：TODO
 */
public class Main49 {

    public static void main(String[] args) {
        Main49 main49 = new Main49();
        System.out.println(main49.getUglyNumberSolution(10));
        System.out.println("aaa");
    }

    public int getUglyNumberSolution(int n) {

        if (n <= 6) {
            return n;
        }

        int[] nums = new int[n];
        int i2 = 1;
        int i3 = 1;
        int i5 = 1;
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            if (i2 * 2 < Math.min(i3 * 3, i5 * 5)) {
                nums[i] = i2 * 2;
                i2++;
                if (nums[i] % 3 == 0) {
                    i3++;
                }
                if (nums[i] % 5 == 0) {
                    i5++;
                }
            } else if (i3 * 3 < i5 * 5) {
                nums[i] = i3 * 3;
                i3++;
                if (nums[i] % 2 == 0) {
                    i2++;
                }
                if (nums[i] % 5 == 0) {
                    i5++;
                }
            } else {
                nums[i] = i5 * 5;
                i5++;
                if (nums[i] % 2 == 0) {
                    i2++;
                }
                if (nums[i] % 3 == 0) {
                    i3++;
                }
            }
        }
        return nums[n - 1];
    }



}
