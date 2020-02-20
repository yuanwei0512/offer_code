package com.hyw.offer.leet.code;

import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/19 15:20
 * Description：TODO
 */
public class Main131 {

    private LinkedList<String> segment = new LinkedList<>();
    private List<List<String>> resultList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (null == s || s.length() == 0) {
            return Collections.emptyList();
        }
        getSegment(s, 0);
        return resultList;
    }

    private void getSegment(String s, int l) {
        if (l == s.length()) {
            resultList.add(new ArrayList<>(segment));
            return;
        }
        for (int i = l; i < s.length(); i++) {
            if (!checkPalindrome(s, l, i)) {
                continue;
            }
            segment.add(s.substring(l, i + 1));
            getSegment(s, i + 1);
            segment.removeLast();
        }

    }

    private boolean checkPalindrome(String s, int l, int r) {
        while (l < r) {
            if (!(s.charAt(l) == s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Main131 main131 = new Main131();
        System.out.println(main131.partition("adavad"));
    }

}
