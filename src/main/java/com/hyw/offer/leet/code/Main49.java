package com.hyw.offer.leet.code;

import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/13 22:22
 * Description：TODO
 */
public class Main49 {

    public static void main(String[] args) {
        Main49 main49 = new Main49();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(main49.groupAnagrams(str));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> hashMap = new HashMap<>(strs.length);

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);

            if (!hashMap.containsKey(s)) {
                hashMap.put(s, new ArrayList<>());
            }
            hashMap.get(s).add(str);


        }
        return new ArrayList<>(hashMap.values());

    }

}
