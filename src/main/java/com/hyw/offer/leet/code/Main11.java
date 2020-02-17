package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/10 17:44
 * Description：TODO
 */
public class Main11 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Main11 main11 = new Main11();
        System.out.println(main11.maxArea(height));

    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int max = 0;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;

    }
}
