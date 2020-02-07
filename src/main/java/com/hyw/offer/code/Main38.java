package com.hyw.offer.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/6 16:12
 * Description：TODO
 */
public class Main38 {

    public static void main(String[] args) {
        String input = "abc";
        Main38 main38 = new Main38();
        System.out.println(main38.permutation(input));

    }

    public List<String> permutation(String str) {

        if (str.length() == 0) {
            return Collections.emptyList();
        }

        char[] chars = str.toCharArray();


        int size = Stream.iterate(1, x -> x + 1).limit(chars.length)
                .reduce(1, (x, y) -> x * y);
        List<String> ret = new ArrayList<>(size);

        int changeIndex = 1;
        for (int i = 0; i < size; i++) {

            char temp = chars[0];
            chars[0] = chars[changeIndex];
            chars[changeIndex++] = temp;

            if (changeIndex == chars.length) {
                changeIndex = 1;
            }
            System.out.println(Arrays.toString(chars));

        }
        return ret;
    }




}
