package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/22 14:06
 * Description：TODO
 */
public class Main14 {

    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"};
        Main14 main14 = new Main14();
        System.out.println(main14.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        int mid = (r - l) / 2 + l;
        String left = longestCommonPrefix(strs, l, mid);
        String right = longestCommonPrefix(strs, mid + 1, r);
        return commonPrefix(left, right);
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}
