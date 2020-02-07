package com.hyw.java8.stream13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/13 9:43
 * Description：TODO
 */
public class MyTest {

    public static void main(String[] args) {

        Stream<Integer> limit = Stream.iterate(2, i -> i + 1)
                .filter(MyTest::isPrime)
                .limit(5);


    }

    public static boolean isPrime(int candidate) {

        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(x -> candidate % x == 0);
    }

    private static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }


    public static long facotrialHelper(long acc, long n) {
        return n == 1 ? acc : facotrialHelper(acc * n, n -1 );
    }

    public static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }

        Integer first = list.get(0);

        List<Integer> rest = list.subList(1, list.size());

        List<List<Integer>> subans = subsets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);

    }

    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    private static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }



}
