package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/23 16:01
 * Description：TODO
 */
public class Main28 {

    public static void main(String[] args) {

        Main28 main28 = new Main28();
        System.out.println(main28.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0 || haystack.equals(needle)) {
            return 0;
        }
        int n = needle.length();
        a:
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            if (haystack.charAt(i) == needle.charAt(j++)) {
                for (int l = i + 1; l - i + 1 <= n && l < haystack.length(); l++) {
                    if (haystack.charAt(l) != needle.charAt(j++)) {
                        continue a;
                    }
                }
                if (j == n) {
                    return i;
                }
            }
        }
        return -1;

    }
}
