package com.hyw.offer.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/8 22:16
 * Description：TODO
 */
public class Main50 {

    public static void main(String[] args) {
        Main50 main50 = new Main50();
        System.out.println(main50.firstNotRepeatingChar("abaccdeff"));

    }

    public String firstNotRepeatingChar(String str) {

        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("非法参数异常");
        }
        String[] split = str.split("");
        Map<String, Integer> hashMap = new HashMap<>(str.length());
        for (String s : split) {
            hashMap.compute(s, (k, v) -> v == null ? 1 : v + 1);
        }
        for (String s : split) {
            if (hashMap.get(s) == 1) {
                return s;
            }
        }
        return "null";
    }

}
