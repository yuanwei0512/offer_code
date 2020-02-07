package com.hyw.cart;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/11/7 14:10
 * Description：TODO
 */
public class OptionStudy {


    @Test
    public void test() throws Throwable {

        List<String> list =new ArrayList<>();
        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);
    }
}
