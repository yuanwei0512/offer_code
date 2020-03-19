package com.hyw.offer.leet.code;

import com.hyw.offer.code.Main45;

import java.util.Arrays;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/5 15:32
 * Description：TODO
 */
public class Main455 {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length - 1;
        int si = s.length - 1;
        int res = 0;

        while (gi >= 0 && si >= 0) {
            if (g[gi] <= s[si]) {
                res++;
                gi--;
                si--;
            } else {
                gi--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] nums2 = {1,1};
        Main455 main455 = new Main455();
        System.out.println(main455.findContentChildren(nums, nums2));
    }

}
