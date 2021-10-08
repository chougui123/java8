package com.atguigu.exr;

import com.atguigu.java8.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

    List<Employee> list= Arrays.asList(
      new Employee("张三",22,9999),
        new Employee("李四",20,9999),
            new Employee("王五",26,9999)
    );

    @org.junit.Test
    public void test01(){
        Collections.sort(list,(e1,e2) ->{
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for(Employee emp : list){
            System.out.println(emp);
        }
    }


    @org.junit.Test
    public void test02(){
        String up = upper("abcdef", (str) -> str.toUpperCase());
        System.out.println(up);

        String trim = upper("\t\t\t abcdef", (str) -> str.trim());
        System.out.println(trim);
    }

    public String upper(String str,MyFunction mf){
        return mf.getValue(str);
    }


    @org.junit.Test
    public void test03(){
        op(100L,200L,((t1, t2) -> t1+t2));
        op(100L,200L,((t1, t2) -> t1*t2));
    }

    public void op(Long t1,Long t2,MyFunction2<Long,Long> mf){
        System.out.println(mf.getValue(t1, t2));
    }


}
