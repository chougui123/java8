package com.atguigu.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class TestLambda {

    @Test
    public void test01(){
        Runnable runnable=() -> System.out.println("hello lambda");
        runnable.run();
    }

    @Test
    public void test02(){
        Consumer<Integer> consumer= x-> System.out.println(x);
        consumer.accept(1);
    }

    @Test
    public void test03(){
        Comparator<Integer> comp = (x, y) -> {
            System.out.println("hello, lambda");
            return Integer.compare(x, y);
        };

    }

    @Test
    public void test04(){
        Comparator<Integer> com=(x,y) -> Integer.compare(x,y);
    }

    @Test
    public void test05(){
        Integer operation = operation(100, x -> x * x);
        System.out.println(operation);

        Integer operation1 = operation(100, x -> 100 + x);
        System.out.println(operation1);
    }


    public Integer operation(Integer num,MyFun myFun){
        return myFun.getValue(num);
    }
}
