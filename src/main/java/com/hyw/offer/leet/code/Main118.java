package com.hyw.offer.leet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/3/19 14:46
 * Description：TODO
 */
public class Main118 {

    public static void main(String[] args) {
        Main118 main118 = new Main118();
        System.out.println(main118.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> segment = new ArrayList<>();
            segment.add(result.get(i - 1).get(0));
            for (int j = 1; j < i; j++) {
                segment.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            }
            segment.add(result.get(i - 1).get(i - 1));
            result.add(segment);

        }
        return result;
    }

}
