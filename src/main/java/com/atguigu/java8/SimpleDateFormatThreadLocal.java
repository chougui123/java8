package com.atguigu.java8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatThreadLocal {

    public static final ThreadLocal<DateFormat> sdf = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static Date covert(String source) throws ParseException {
        return sdf.get().parse(source);
    }
}
