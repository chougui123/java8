package com.atguigu.java8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.*;

public class TestSimpleDateFormat {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20210911", DateTimeFormatter.ofPattern("yyyyMMdd"));
            }
        };

        ExecutorService pool = newFixedThreadPool(10);

        ArrayList<Future<LocalDate>> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(pool.submit(task));
        }
        for(Future<LocalDate> future:list){
            System.out.println(future.get());
        }
        pool.shutdown();

    }
}
