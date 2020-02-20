package com.hyw.offer.leet.code;

import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/18 15:14
 * Description：TODO
 */
public class Main17 {

    private Map<Integer, String> map = new HashMap<>();
    private List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Main17 main17 = new Main17();
        System.out.println(main17.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        joinDigt(digits, 0, "");
        return list;
    }

    private void joinDigt(String digits, int index, String s) {

        //递归到底
        if (index == digits.length()) {
            list.add(s);
            return;
        }

        char c = digits.toCharArray()[index];
        String letter = map.get(c - '0');
        String[] strs = letter.split("");
        for (String str : strs) {
            joinDigt(digits, index+1, s + str);
        }

    }

}
