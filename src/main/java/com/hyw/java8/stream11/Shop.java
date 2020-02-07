package com.hyw.java8.stream11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/11 10:34
 * Description：TODO
 */
public class Shop {


    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(
                new Shop("aaa"),
                new Shop("bbb"),
                new Shop("ccc")
                );

        List<Future<Double>> collect = shops.stream().parallel()
                .map(Shop::getPrice)
                .collect(Collectors.toList());


    }




    private String name;



    public Future<Double> getPrice() {

        return CompletableFuture.supplyAsync(() -> calculatePrice(this.name));
    }

    private double calculatePrice(String produce) {
        delay();
        return ThreadLocalRandom.current().nextDouble() * produce.charAt(0) + produce.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
