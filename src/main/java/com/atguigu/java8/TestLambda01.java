package com.atguigu.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大内置函数式接口
 */
public class TestLambda01 {


    /**
     * 断言式接口
     */
    @Test
    public void predicate(){
         List<String> list =  Arrays.asList("hello", "ni", "china", "world", "java");
         List<String> filterList = filterList(list, pre -> pre.length() > 3);
        for (String str:filterList
             ) {
            System.out.println(str);
        }
    }
    public List<String> filterList(List<String> list, Predicate<String> pre){
        List<String> newList = new ArrayList<>();
        for (String str:list) {
            if(pre.test(str)){
                newList.add(str);
            }
        }
        return newList;
    }

    /**
     * 函数式接口
     */
    @Test
    public void function(){
        strHandler("\t\t\t 你好时间",(s) -> s.trim());
        strHandler("abddjif",(s) -> s.toUpperCase());
    }

    public void strHandler(String str, Function<String,String> fun){
        System.out.println(fun.apply(str));
    }

    /**
     * 供给式接口
     */
    @Test
    public void supplier(){
        List<Integer> numList = getNumList(10, () -> {
            return (int) (Math.random() * 100);
        });
        for (Integer num:numList
             ) {
            System.out.println(num);
        }
    }
    public List<Integer> getNumList(Integer num, Supplier<Integer> sup){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<num;i++){
            Integer integer = sup.get();
            list.add(integer);
        }
        return list;
    }

    /**
     * 消费式接口
     */
    @Test
    public void consumer(){
        happy(10000.0,(t) -> {
            System.out.println("每次消费："+t+"元");
        });
    }

    public void happy(Double d, Consumer<Double> con){
        con.accept(d);
    }
}
