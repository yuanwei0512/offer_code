package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/20 16:01
 * Description：TODO
 */
public class Main {

    public int longestSubstring(String s, int k) {
        if (s == null || s.trim().length() <= k) {
            return 0;
        }
        return getLongestSubstring(s.toCharArray(), k, 0, s.length() - 1);
    }

    private int getLongestSubstring(char[] toCharArray, int k, int start, int end) {

        if (start >= end) {
            return 0;
        }

        

    }

}
