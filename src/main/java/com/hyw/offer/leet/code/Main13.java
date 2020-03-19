package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/17 15:26
 * Description：TODO
 */
public class Main13 {

    public int romanToInt(String s) {

        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);


        char[] chars = s.toCharArray();
        int num = romanMap.get(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            num += romanMap.get(chars[i]);
            if (romanMap.get(chars[i - 1]) < romanMap.get(chars[i])) {
                num -= romanMap.get(chars[i - 1]) * 2;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Main13 main13 = new Main13();
        System.out.println(main13.romanToInt("MCMXCIV"));
    }

}
