package com.atguigu.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

public class TestLambda02 {


    /**
     * 方法引用 实体::实体方法
     */
    @Test
    public void test01(){
        Consumer<String> con=(s) -> System.out.println(s);
        PrintStream out = System.out;
        Consumer<String> con1=out::println;
        con1.accept("hello");
        Consumer<String> con2=System.out::println;
    }

    /**
     * 方法引用 className::staticMethod
     */
    @Test
    public void test02(){
        Comparator<Integer> com=(x, y) -> Integer.compare(x,y);

        Comparator<Integer> com1=Integer::compare;
        int compare = com1.compare(1, 2);
        System.out.println(compare);

    }

    /**
     * 方法引用 className::实体方法
     */
    @Test
    public void test03(){
        BiPredicate<String,String> bp1=(x,y) -> x.equals(y);
        BiPredicate<String,String> bp=String::equals;
        boolean test = bp.test("a", "b");
        System.out.println(test);
    }


    /**
     * 构造器引用 className::new
     */
    @Test
    public void test04(){
        Supplier<Employee> sp = () -> new Employee();
        Supplier<Employee> sp1 =Employee::new;
        Employee employee = sp1.get();
        System.out.println(employee);

        Function<String,Employee> fun=Employee::new;
        Employee e = fun.apply("liMing");
        System.out.println(e);

        BiFunction<String,Integer,Employee> bf=Employee::new;
        Employee e1 = bf.apply("Danio", 20);
        System.out.println(e1);
    }

    /**
     * 数组引用
     */
    @Test
    public void test05(){
        Function<Integer,String[]> function=String[]::new;
        String[] apply = function.apply(10);
        System.out.println(apply.length);
    }

}
