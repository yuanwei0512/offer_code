package com.hyw.offer.code;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/11 17:12
 * Description：TODO
 */
public class Main48 {

    public static void main(String[] args) {
        Main48 main48 = new Main48();
        System.out.println(main48.longestSubstring("abcdabcdbbadb"));
    }

    public int longestSubstring(String str) {
        char[] chars = str.toCharArray();
        int l = 0;
        int r = 0;
        int maxLength = 1;
        boolean flag = false;
        while (l < chars.length && r < chars.length) {
            flag = false;
            int i = r;
            for (; i > l; ) {
                if (chars[--i] == chars[r]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int j = l; j < r; j++) {
                    System.out.print(chars[j]);
                }
                System.out.println();
                maxLength = Math.max(maxLength, r - l);
                l = i + 1;
            }
            r++;
        }
        return maxLength;
    }

}
