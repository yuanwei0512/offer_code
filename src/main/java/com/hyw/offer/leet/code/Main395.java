package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/20 16:01
 * Description：TODO
 */
public class Main395 {

    public static void main(String[] args) {
        Main395 main395 = new Main395();

        System.out.println(main395.longestSubstring("a", 1));
    }

    public int longestSubstring(String s, int k) {
        if (s == null || s.trim().length() < k) {
            return 0;
        }
        return getLongestSubstring(s.toCharArray(), k, 0, s.length() - 1);
    }

    private int getLongestSubstring(char[] chars, int k, int start, int end) {

        if (end - start + 1 < k) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = start; i <= end; i++) {
            map.merge(chars[i], 1, Integer::sum);
        }

        for (int i = start; i <= end; i++) {
            if (map.get(chars[i]) < k) {
                return Math.max(getLongestSubstring(chars, k, start, i - 1), getLongestSubstring(chars, k, i + 1, end));
            }
        }
        return end - start + 1;

    }

}
