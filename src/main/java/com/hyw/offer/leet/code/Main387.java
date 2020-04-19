package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/24 17:14
 * Description：TODO
 */
public class Main387 {

    public static void main(String[] args) {
        Main387 main387 = new Main387();
        System.out.println(main387.firstUniqChar("leetcode"));
    }

    public int firstUniqChar(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.merge(chars[i], 1, Integer::sum);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

}
