package com.hyw.offer.leet.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/12 17:26
 * Description：TODO
 */
public class Main242 {

    public boolean validAnagram(String s, String t) {

        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return new String(chars).equals(new String(chars1));

    }

    public static void main(String[] args) {
        Main242 main242 = new Main242();
        System.out.println(main242.validAnagram("anagram", "nagaram"));
    }

}
