package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/21 16:42
 * Description：TODO
 */
public class Main5 {

    public static void main(String[] args) {
        Main5 main5 = new Main5();
        System.out.println(main5.longestPalindrome("ababababababa"));
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int j;
        int k;
        String result = String.valueOf(chars[0]);
        for (int i = 0; i < n; i++) {
            j = k = i;
            while (k < n - 1 && chars[k + 1] == chars[k]) {
                k++;
            }
            while (j > 0 && k < n - 1 && chars[j - 1] == chars[k + 1]) {
                j--;
                k++;
            }
            if (j < k && (k - j + 1) > result.length()) {
                result = s.substring(j, k + 1);
            }
        }
        return result;
    }

}
