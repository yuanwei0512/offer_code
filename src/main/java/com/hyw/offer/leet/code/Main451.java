package com.hyw.offer.leet.code;

import java.util.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/13 15:15
 * Description：TODO
 */
public class Main451 {

    public static void main(String[] args) {
        Main451 main451 = new Main451();
        System.out.println(main451.frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        if (null == s || s.length() == 0) {
            return "null";
        }

        String[] split = s.split("");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : split) {
            frequencyMap.merge(str, 1, Integer::sum);
        }
        List<Map.Entry<String, Integer>> entrieList = new ArrayList<>(frequencyMap.entrySet());

        Collections.sort(entrieList, (o1, o2) -> -Integer.compare(o1.getValue(), o2.getValue()));
        StringBuilder resultBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entrieList) {
            for (int i = 0; i < entry.getValue(); i++) {
                resultBuilder.append(entry.getKey());
            }
        }
        return resultBuilder.toString();
    }
}
