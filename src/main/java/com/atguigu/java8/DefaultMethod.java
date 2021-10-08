package com.atguigu.java8;

/**
 * @author coca cola
 */
public class DefaultMethod /*extends MyClass*/ implements MyInterface01,MyInterface02{


    @Override
    public String msg() {
      return   MyInterface01.super.msg();
    }
}
