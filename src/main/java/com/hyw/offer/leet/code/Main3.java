package com.hyw.offer.leet.code;

import java.util.HashSet;
import java.util.Set;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/21 16:09
 * Description：TODO
 */
public class Main3 {

    public static void main(String[] args) {
        Main3 main3 = new Main3();
        System.out.println(main3.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] chars = s.toCharArray();
        int n = chars.length;
        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;

        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (!set.contains(chars[j])) {
                set.add(chars[j++]);
                max = Math.max(max, j - i);
            } else {
                set.remove(chars[i++]);
            }
        }

        return max;
    }
}
