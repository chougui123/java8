package com.atguigu.java8;

import org.junit.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamAPI02 {

    List<Employee> employees= Arrays.asList(
            new Employee("张三",22,3333, Employee.Status.BUSY),
            new Employee("李四",20,6666,Employee.Status.FREE),
            new Employee("王五",56,9999,Employee.Status.BUSY),
            new Employee("王五",36,9999,Employee.Status.BUSY),
            new Employee("王五",26,9999,Employee.Status.BUSY)
    );

    @Test
    public void test10(){
        String collect = employees.stream().map(Employee::getName).collect(Collectors.joining("，","姓名：","结尾"));
        System.out.println(collect);
    }

    @Test
    public void test09(){
        DoubleSummaryStatistics collect = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect.getCount());
        System.out.println(collect.getSum());
        System.out.println(collect.getMax());
        System.out.println(collect.getAverage());
        System.out.println(collect.getMin());
    }

    @Test
    public void test08(){
        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 35));
        System.out.println(collect);
    }


    @Test
    public void test07(){
        Map<Employee.Status, Map<String, List<Employee>>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
            if (e.getAge() <= 35) {
                return "青年";
            } else if (e.getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        System.out.println(collect);
    }

    @Test
    public void test06(){
        Map<Employee.Status, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);
    }

    @Test
    public void test05(){
        Long collect = employees.stream().collect(Collectors.counting());
        System.out.println("总数为："+collect);
        Double collect1 = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect1);
        Double collect2 = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect2);
        Optional<Employee> collect3 = employees.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(collect3);
        Optional<Double> collect4 = employees.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
        System.out.println(collect4);
    }

    @Test
    public void test04(){
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(collect);
        Set<String> set = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        System.out.println(set);
    }


    @Test
    public void test03(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1.get());
    }

    @Test
    public void test02(){
        long count = employees.stream().count();
        System.out.println(count);

        Optional<Employee> max = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get());

        Optional<Integer> min = employees.stream().map(Employee::getAge).min((e1, e2) -> Integer.compare(e1, e2));
        System.out.println(min.get());
    }
    /**
     * 查询与匹配
     */
    @Test
    public void test01(){
        boolean a = employees.stream().allMatch((x) -> x.getStatus().equals(Employee.Status.BUSY));
        System.out.println(a);
        boolean b = employees.stream().anyMatch((x) -> x.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
        boolean b1 = employees.stream().noneMatch((x) -> x.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first.get());
        Optional<Employee> any = employees.stream().filter((x) -> x.getStatus().equals(Employee.Status.BUSY)).findAny();
        System.out.println(any.get());
    }
}
