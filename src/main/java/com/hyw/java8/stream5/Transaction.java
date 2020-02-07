package com.hyw.java8.stream5;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/5 9:03
 * Description：TODO
 */
public class Transaction {

    private final Trader trader;

    private final int year;

    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
