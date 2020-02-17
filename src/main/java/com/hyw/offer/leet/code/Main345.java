package com.hyw.offer.leet.code;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/10 17:10
 * Description：TODO
 */
public class Main345 {

    public static void main(String[] args) {
        Main345 main345 = new Main345();
        System.out.println(main345.reversVowels("leetcode"));
    }

    public String reversVowels(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("非法参数异常");
        }
        Set<String> vovelSet = Sets.newHashSet("a", "e", "i", "o", "u");
        String[] strs = str.split("");
        int i = 0;
        int j = strs.length - 1;
        String temp;
        while (true) {
            while (!vovelSet.contains(strs[i])) {
                i++;
            }
            while (!vovelSet.contains(strs[j])) {
                j--;
            }
            if (i >= j) {
                break;
            }
            temp = strs[j];
            strs[j] = strs[i];
            strs[i] = temp;
            i++;
            j--;


        }
        return Arrays.toString(strs);
    }
}
