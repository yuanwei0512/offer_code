package com.hyw.java8.stream12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;

/**
 * Project：study_996     @author 源伟
 * DateTime：2019/12/11 13:28
 * Description：TODO
 */
public class MyTest {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 10, 20);

        TemporalAdjuster temporalAdjuster = TemporalAdjusters.ofDateAdjuster(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            } else if (dow == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });

        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .toFormatter();

    }

}
