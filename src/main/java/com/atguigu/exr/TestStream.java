package com.atguigu.exr;

import com.atguigu.java8.Employee;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

public class TestStream {
    List<Employee> employees= Arrays.asList(
            new Employee("张三",22,3333, Employee.Status.BUSY),
            new Employee("李四",20,6666,Employee.Status.FREE),
            new Employee("王五",56,9999,Employee.Status.BUSY),
            new Employee("王五",36,9999,Employee.Status.BUSY),
            new Employee("王五",26,9999,Employee.Status.BUSY)
    );

    @Test
    public void test01(){
        Integer[] num = {1, 2, 3, 4, 5};
        Optional<Integer> reduce = Arrays.stream(num).map(x -> x * x).reduce(Integer::sum);
        System.out.println(reduce.get());
    }

    @Test
    public void test02(){
        Optional<Integer> reduce = employees.stream().map(x -> 1).reduce(Integer::sum);
        System.out.println(reduce.get());
    }

    /**
     * 并行流 frok-join框架
     */
    @Test
    public void test03(){
        Instant start = Instant.now();
        long reduce = LongStream.rangeClosed(0, 100000000000L)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println(reduce);
        Instant end = Instant.now();
        System.out.println("耗时："+ Duration.between(start,end).toMillis());
    }

}
