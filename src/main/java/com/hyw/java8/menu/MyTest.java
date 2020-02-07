package com.hyw.java8.menu;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/4 10:08
 * Description：TODO
 */
public class MyTest {

    public enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String[] args) {

        List<Dish> dishList = Arrays.asList(
                new Dish("鱼", false, 20, Dish.Type.FISH),
                new Dish("蔬菜", true, 20, Dish.Type.OTHER)
        );


    }

    private static boolean isPrime(int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.range(2, candidateRoot)
                .boxed()
                .noneMatch(x -> candidateRoot % x == 0);

    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n){
        return IntStream.range(2, n)
                .boxed()
                .collect(partitioningBy(MyTest::isPrime));
    }


}
