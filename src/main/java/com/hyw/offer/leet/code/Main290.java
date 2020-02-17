package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/13 11:27
 * Description：TODO
 */
public class Main290 {


    public static void main(String[] args) {
        Main290 main290 = new Main290();
        System.out.println(main290.wordPattern("abba", "dog cat cat dog"));
        System.out.println(main290.wordPattern("abba", "dog cat cat fish"));
    }

    public boolean wordPattern(String a, String b) {
        if (a == null || a.length() == 0) {
            return false;
        }
        String[] splitA = a.split("");
        String[] splitB = b.split(" ");

        if (splitA.length != splitB.length) {
            return false;
        }

        Map<String, String> patterMap = new HashMap<>(splitA.length);

        for (int i = 0; i < splitA.length; i++) {
            patterMap.putIfAbsent(splitA[i], splitB[i]);
            String value = patterMap.get(splitA[i]);
            if (!Objects.equals(value, splitB[i])) {
                return false;
            }
        }
        return true;
    }

}
