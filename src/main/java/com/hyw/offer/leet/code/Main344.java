package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/17 15:35
 * Description：TODO
 */
public class Main344 {

    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        Main344 main344 = new Main344();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        main344.reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);

        }
    }

}
