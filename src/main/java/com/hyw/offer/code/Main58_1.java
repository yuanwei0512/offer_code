package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/8 16:28
 * Description：TODO
 */
public class Main58_1 {

    public static void main(String[] args) {
        Main58_1 main58_1 = new Main58_1();
        System.out.println(main58_1.reverseSentence("i am a student"));
    }

    public String reverseSentence(String str) {

        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);

        int l = 0;
        int r = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' || chars[i] == chars.length - 1) {
                r = i - 1;
                reverse(chars, l, r);
                l = i + 1;
            }
        }
        return new String(chars);
    }

    private void reverse(char[] c, int l, int r) {
        while (l < r) {
            swap(c, l++, r--);
        }
    }

    private void swap(char[] c, int l, int r) {
        char temp = c[l];
        c[l] = c[r];
        c[r] = temp;
    }

}
