package com.xiaokaige.date;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTest {
    public static void main(String[] args) {
        //构建一个时间日期并按指定格式进行解析
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeStr = date.format(formatter);
        System.out.println("timeStr = " + timeStr);

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);

        int dayOfMonth = date.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);

        int dayOfYear = date.getDayOfYear();
        System.out.println("dayOfYear = " + dayOfYear);
    }

}
