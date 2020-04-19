package com.hyw.offer.leet.code;

import java.util.Arrays;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/22 14:33
 * Description：TODO
 */
public class Main179 {

    public static void main(String[] args) {
        Main179 main179 = new Main179();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(main179.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return -str1.compareTo(str2);
        });

        if (strs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

}
