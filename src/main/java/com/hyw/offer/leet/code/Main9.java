package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/29 17:29
 * Description：TODO
 */
public class Main9 {

    public static void main(String[] args) {
        Main9 main9 = new Main9();
        System.out.println(main9.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        System.out.println(chars.length >> 1);
        for (int i = 0; i < chars.length >> 1; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
