package com.hyw.java8;



import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/4 8:42
 * Description：TODO
 */
public class AppleTest {

    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transform = addHeader.andThen(Letter::addFooter);
        System.out.println(transform.apply("1"));


    }

    public static class Letter{

        public static String addHeader(String text){
            return "添加头" + text;
        }

        public static String addFooter(String text){
            return "添加尾巴" + text;
        }

    }

}
