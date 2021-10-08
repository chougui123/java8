package com.atguigu.java8;

public class TestDefaultMethod {

    public static void main(String[] args) {
        DefaultMethod defaultMethod = new DefaultMethod();
        String msg = defaultMethod.msg();
        System.out.println(msg);
        MyInterface01.show();
    }
}
