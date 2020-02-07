package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/31 14:12
 * Description：TODO
 */
public class Main5 {

    public String replaceSpace(StringBuffer str) {
        int p1 = str.length();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length();

        while (p1 > 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }

}
