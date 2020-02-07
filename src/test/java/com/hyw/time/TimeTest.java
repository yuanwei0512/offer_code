package com.hyw.time;

import org.junit.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Currency;
import java.util.Locale;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/2 8:32
 * Description：TODO
 */
public class TimeTest {

    @Test
    public void test4() throws ParseException {
        Locale china = Locale.CHINA;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        numberFormat.setCurrency(Currency.getInstance("EUR"));
        double amt = 12345.65;
        String format = numberFormat.format(amt);
        System.out.println(format);
        System.out.println("-------------");
        System.out.println(numberFormat.parse(format).doubleValue());





















    }


    @Test
    public void test3() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");
        System.out.println(dateTimeFormatter.format(now));

    }


    @Test
    public void test2() throws InterruptedException {

        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate localDate = LocalDate.of(1903, Month.JULY, 16).plusDays(255).plusYears(1);
        System.out.println(localDate);
        System.out.println(localDate.until(now, ChronoUnit.DAYS));
        LocalDate with = localDate.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.MONDAY));

    }


    @Test
    public void test1() throws InterruptedException {
        Instant start = Instant.now();
        Thread.currentThread().sleep(1000);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        System.out.println(between.toMillis());

    }
}
