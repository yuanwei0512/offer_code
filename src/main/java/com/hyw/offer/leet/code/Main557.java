package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/29 17:05
 * Description：TODO
 */
public class Main557 {

    public static void main(String[] args) {
        Main557 main557 = new Main557();
        System.out.println(main557.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }

        String s1 = sb.reverse().toString();
        String[] s2 = s1.split(" ");
        StringBuffer sb2 = new StringBuffer();
        for (int i = s2.length - 1; i >= 0; i--) {
            sb2.append(s2[i] + " ");
        }

        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }

}
