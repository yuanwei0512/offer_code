package com.hyw.offer.leet.code;

import java.util.*;
import java.util.stream.Collectors;

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
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> strings = map.get(s);
            if (strings == null) {
                ArrayList<String> value = new ArrayList<>();
                value.add(str);
                map.put(s, value);
            } else {
                strings.add(str);
            }
        }
        return map.values().stream().collect(Collectors.toList());


    }

}
