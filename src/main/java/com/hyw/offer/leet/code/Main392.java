package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/5 15:41
 * Description：TODO
 */
public class Main392 {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.trim().length() == 0 ) {
            return true;
        }
        if (t == null || t.trim().length() == 0) {
            return false;
        }
        int sIndex = 0;
        int tIndex = 0;

        while (tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                if (sIndex == s.length()) {
                    return true;
                }
            }
            tIndex++;

        }
        return false;
    }

    public static void main(String[] args) {
        Main392 main392 = new Main392();
        System.out.println(main392.isSubsequence("abc", "ahgdcb"));
    }

}
