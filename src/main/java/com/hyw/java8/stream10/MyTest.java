package com.hyw.java8.stream10;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/9 10:08
 * Description：TODO
 */
public class MyTest {

    public static void main(String[] args) {
        Dish dish = new Dish("aa", true, 10, Dish.Type.FISH);
        Optional<String> s = Optional.of(dish).map(Dish::getName);



    }

}
