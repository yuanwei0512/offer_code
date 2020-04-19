package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/24 17:06
 * Description：TODO
 */
public class Main412 {

    public static void main(String[] args) {
        Main412 main412 = new Main412();
        System.out.println(main412.fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {

        List<String> resultList = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        map.put(15, "FizzBuzz");
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                resultList.add(map.get(15));
            } else if (i % 3 == 0) {
                resultList.add(map.get(3));
            } else if (i % 5 == 0) {
                resultList.add(map.get(5));
            } else {
                resultList.add(String.valueOf(i));
            }
        }
        return resultList;
    }

}
