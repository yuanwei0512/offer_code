package com.hyw.offer.leet.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/4/1 21:46
 * Description：TODO
 */
public class Main647 {

    public static void main(String[] args) {
        Main647 main647 = new Main647();
        System.out.println(main647.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            count += tryCount(s, i, i);
            if (s.charAt(i) == s.charAt(i + 1)) {
                count += tryCount(s, i, i + 1);
            }
        }
        count++;
        return count;
    }

    private int tryCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

}
