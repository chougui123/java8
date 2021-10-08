package com.atguigu.java8;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI01 {

    List<Employee> employees= Arrays.asList(
            new Employee("张三",22,3333),
            new Employee("李四",20,6666),
            new Employee("王五",26,9999),
            new Employee("王五",26,9999),
            new Employee("王五",26,9999)
    );


    /**
     * 排序
     */
    @Test
    public void test04(){
        List<String> list = Arrays.asList("cc", "aa", "dd");
        list.stream().sorted().forEach(System.out::println);

        employees.stream().sorted((e1,e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        }).forEach(System.out::println);
    }
    /**
     * 映射
     */
    @Test
    public void test03(){
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map((x) -> x.toUpperCase()).forEach(System.out::println);
//        employees.stream().map(Employee::getName).forEach(System.out::println);
//        Stream<Stream<Character>> sm = list.stream().map(TestStreamAPI01::filterCharacter);
//        sm.forEach((s) -> s.forEach(System.out::println));
        list.stream().flatMap(TestStreamAPI01::filterCharacter).forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character ch: str.toCharArray()) {
            list.add(ch);
        };
        return list.stream();
    }

    /**
     * 筛选与切片
     */
    @Test
    public void test01(){
        employees.stream().filter((x) -> {
                    System.out.println("中间操作");
            return x.getAge() > 20;
        }
            ).limit(1).forEach(System.out::println);
    }

    @Test
    public void test02(){
        employees.stream().filter((x) -> x.getSalary() > 5000).skip(1).distinct().forEach(System.out::println);
    }
}
