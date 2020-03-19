package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/12 16:22
 * Description：TODO
 */
public class Main8 {

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        boolean negtive = false;
        StringBuffer sb = new StringBuffer();
        for (char c : chars) {
            if (c == ' ') {
                continue;
            }
            if (sb.length() == 0 && c == '-') {
                negtive = true;
                continue;
            }
            if (c > '0' && c <= '9') {
                sb.append(c);
            } else {
                break;
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        if (negtive) {
            return -Integer.valueOf(sb.toString());
        } else {
            return Integer.valueOf(sb.toString());
        }

    }

    public static void main(String[] args) {
        Main8 main8 = new Main8();
        System.out.println(main8.myAtoi("-91283472332"));
    }

}
