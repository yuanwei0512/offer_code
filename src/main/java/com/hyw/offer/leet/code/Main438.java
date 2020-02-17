package com.hyw.offer.leet.code;

import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/11 20:43
 * Description：TODO
 */
public class Main438 {

    public static void main(String[] args) {
        Main438 main438 = new Main438();
        System.out.println(main438.getAnagrams("abab", "ba"));
    }

    public List getAnagrams(String a, String b) {
        if (a == null && a.length() == 0) {
            return null;
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Set<Character> bSet = new HashSet<>(bChars.length);
        for (char bChar : bChars) {
            bSet.add(bChar);
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        int l = 0;
        int r = l + b.length() - 1;
        Set<Character> checkSet = new HashSet<>(bChars.length);
        while (r < aChars.length) {
            int i = r;
            for (; i >= l; i--) {
                if (!bSet.contains(aChars[i])) {
                    break;
                }
                checkSet.add(aChars[i]);
            }
            if (checkSet.size() == bChars.length) {
                System.out.println(l);
                resultList.add(l);
                l++;
                r++;
            } else {
                //因为 上面for正常结束后i会多执行一次i--
                l = i + 1 + 1;
                r = l + b.length() - 1;
            }

            checkSet.clear();
        }

        return resultList;
    }

}
