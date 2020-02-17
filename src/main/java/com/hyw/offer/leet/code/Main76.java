package com.hyw.offer.leet.code;

import java.util.HashSet;
import java.util.Set;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/12 14:49
 * Description：TODO
 */
public class Main76 {

    public String minWindow(String s, String t) {

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Set<Character> tSet = new HashSet<>(charsT.length);
        for (char c : charsT) {
            tSet.add(c);
        }

        Set<Character> containSet = new HashSet<>(charsT.length);
        int l = 0;
        int r = 0;
        int minLength = charsS.length;
        String minString = "";
        int nextL = 0;


        while (l < charsS.length && r < charsS.length) {
            if (tSet.contains(charsS[r])) {
                containSet.add(charsS[r]);
                if (containSet.size() == 1) {
                    l = r;
                } else if (containSet.size() == 2) {
                    if (charsS[l] == charsS[r]) {
                        l = nextL;
                    }
                    nextL = r;
                } else if (containSet.size() == charsS.length) {
                    if ((r - l + 1) < minLength) {
                        minLength = r - 1 + 1;
                        minString = s.substring(l, r + 1);
                    }
                    containSet.remove(charsS[l]);
                    l = nextL;
                    nextL = r;
                }
            }


            r++;
        }

        return minString;
    }

    public static void main(String[] args) {

        String s = "a";
        String t = "a";
        Main76 main76 = new Main76();
        System.out.println(main76.minWindow(s, t));
    }

}
