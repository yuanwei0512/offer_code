package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/12 17:26
 * Description：TODO
 */
public class Main242 {

    public boolean validAnagram(String a, String b) {

        String[] splitA = a.split("");
        Map<String, Integer> mapA = new HashMap<>(splitA.length);

        for (String s : splitA) {
            mapA.merge(s, 0, Integer::sum);
        }

        String[] splitB = a.split("");
        Map<String, Integer> mapB = new HashMap<>(splitB.length);
        for (String s : splitB) {
            mapB.merge(s, 0, Integer::sum);
        }

        if (mapA.keySet().size() != mapB.keySet().size()) {
            return false;
        }

        AtomicBoolean result = new AtomicBoolean(true);
        mapA.forEach((k, v) -> {
            if (mapB.containsKey(k)) {
                if (!mapB.get(k).equals(v)) {
                    result.set(false);
                    return;
                }
            }
        });
        return result.get();
    }

    public static void main(String[] args) {

    }

}
