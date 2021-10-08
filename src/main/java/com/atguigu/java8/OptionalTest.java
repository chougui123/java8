package com.atguigu.java8;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test01(){
        Optional<Object> o = Optional.of(new Employee());
        System.out.println(o.get());
    }
    @Test
    public void test02(){
        Optional<Object> o = Optional.empty();
        System.out.println(o.get());
    }
    @Test
    public void test03(){
        Optional<Object> o = Optional.ofNullable(null);
        if(o.isPresent())
         {
             System.out.println(o.get());
        }else {
            Object o1 = o.orElse(new Employee("藏"));
            System.out.println(o1);
        }

    }
    @Test
    public void test04(){
        Optional<Employee> zhng = Optional.ofNullable(null);
      /*  Optional<String> s = zhng.map(Employee::getName);
        System.out.println(s.get());
*/
        Optional<String> s1 = zhng.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(s1.get());

    }
}
