package com.hyw.offer.leet.code;

import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/10 14:58
 * Description：TODO
 */
public class Main20 {

    public static void main(String[] args) {
        Main20 main20 = new Main20();
        System.out.println(main20.isValid("([)]"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (map.get(pop) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }





}
