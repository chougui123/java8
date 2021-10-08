package com.atguigu.java8;

import org.junit.Test;

import java.lang.reflect.Method;

public class TestAnnotation {



    @Test
    public void test01() throws NoSuchMethodException {

        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method show = clazz.getMethod("show");
        MyAnnotation[] mas = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation ma:
             mas) {
            System.out.println(ma.value());
        }
    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("string") String str){

    }
}
