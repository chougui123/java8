package com.atguigu.java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestNewTime {

    /**
     * LocalDate LocalTime LocalDateTime
     */
    @Test
    public void test01(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime old = LocalDateTime.of(2020, 6, 18, 18, 00);
        System.out.println(old);
        System.out.println(old.plusYears(2));
        System.out.println(old.minusMonths(1));

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
    }

    @Test
    public void test02(){
        Instant now = Instant.now();
        System.out.println(now);
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        Instant instant = Instant.ofEpochSecond(60);
        System.out.println(instant);
    }

    /**
     * Duration Period
     */
    @Test
    public void test03(){
        Instant now = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        System.out.println(between.toMillis());
        System.out.println("--------------------------");
        LocalTime now2 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime now3 = LocalTime.now();
        Duration between1 = Duration.between(now2, now3);
        System.out.println(between1.toMillis());
    }

    /**
     * Period
     */
    @Test
    public void test04(){
        LocalDate ld = LocalDate.of(2015, 1, 1);
        LocalDate now = LocalDate.now();
        Period between = Period.between(ld, now);
        System.out.println(between);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
    }

    /**
     * 时间校正器 temporalAdjuster
     */
    @Test
    public void test05(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime now1 = now.withDayOfMonth(10);
        System.out.println(now1);
        LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(with);

        LocalDateTime with1 = now.with(temporal -> {
            LocalDateTime temporal1 = (LocalDateTime) temporal;
            if(temporal1.equals(DayOfWeek.FRIDAY)){
                return temporal1.plusDays(3);
            }else if(temporal1.equals(DayOfWeek.SATURDAY)){
                return temporal1.plusDays(2);
            }else {
                return temporal1.plusDays(1);
            }
        }
        );
        System.out.println(with1);
    }

    /**
     * 日期时间格式化
     */
    @Test
    public void test06(){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(formatter);
        System.out.println(format);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime now1 = LocalDateTime.now();
        String format1 = now1.format(formatter1);
        System.out.println(format1);

    }

    /**
     * 时区
     */
    @Test
    public void test07(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }

    @Test
    public void test08(){
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);

        LocalDateTime now1 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime = now1.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
    }
}
