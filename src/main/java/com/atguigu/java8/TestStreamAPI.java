package com.atguigu.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class TestStreamAPI {
    
    @Test
    public void test01(){
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Employee[] emps=new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(emps);

        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);
        stream3.limit(10).forEach(System.out::println);

        Stream<Double> stream4 = Stream.generate(() -> Math.random());
        stream4.limit(5).forEach(System.out::println);

    }
}
