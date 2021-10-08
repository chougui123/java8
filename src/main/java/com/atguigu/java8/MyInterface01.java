package com.atguigu.java8;

public interface MyInterface01 {

    default String msg(){
        return "哈哈哈";
    }

    public static void show(){
        System.out.println("静态方法");
    }
}
