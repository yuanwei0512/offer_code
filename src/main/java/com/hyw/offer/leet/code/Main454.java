package com.hyw.offer.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/13 21:54
 * Description：TODO
 */
public class Main454 {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        Main454 main454 = new Main454();
        System.out.println(main454.fourSumCount(a, b, c, d));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> abMap = new HashMap<>(A.length * B.length);
        Map<Integer, Integer> cdMap = new HashMap<>(C.length * D.length);

        int result = 0;

        for (int i : A) {
            for (int i1 : B) {
                abMap.merge(i + i1, 1, Integer::sum);
            }
        }

        for (int i : C) {
            for (int i1 : D) {
                cdMap.merge(0 - (i + i1), 1, Integer::sum);
            }
        }

        for (Map.Entry<Integer, Integer> abEntry : abMap.entrySet()) {

            Integer value = cdMap.get(abEntry.getKey());
            if (value != null) {
                result += abEntry.getValue() * value;
            }
        }
        return result;
    }
}
