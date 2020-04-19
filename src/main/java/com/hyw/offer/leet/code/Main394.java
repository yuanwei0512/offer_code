package com.hyw.offer.leet.code;

import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/12 17:10
 * Description：TODO
 */
public class Main394 {

    public static void main(String[] args) {
        Main394 main394 = new Main394();
        System.out.println(main394.decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int muti = 0;
        Stack<String> strStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                muti = muti * 10 + Character.digit(c, 10);
            } else if (c == '[') {
                strStack.push(res.toString());
                intStack.push(muti);
                muti = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder preStr = new StringBuilder(strStack.pop());
                Integer preInt = intStack.pop();
                for (int i = 0; i < preInt; i++) {
                    preStr.append(res.toString());
                }
                res = new StringBuilder(preStr);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }


}
