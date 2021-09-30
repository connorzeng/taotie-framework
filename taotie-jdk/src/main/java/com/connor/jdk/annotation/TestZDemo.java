package com.connor.jdk.annotation;

import java.util.Arrays;

public class TestZDemo {


    public static void main(String[] args) {

        //测试 class能不能拿到 Base的注解
        TestClassSub testClassSub = new TestClassSub();

        //打印一下
        Arrays.stream(testClassSub.getClass().getAnnotations()).forEach(System.out::println);
        System.out.println("------");
        Arrays.stream(testClassSub.getClass().getDeclaredAnnotations()).forEach(System.out::println);
        System.out.println("------");

        Arrays.stream(TestClassImplSub.class.getAnnotations()).forEach(System.out::println);
        System.out.println("------");


        Arrays.stream(TestInterfaceSub.class.getAnnotations()).forEach(System.out::println);
        System.out.println("------");
        Arrays.stream(TestInterfaceSub.class.getDeclaredAnnotations()).forEach(System.out::println);
        System.out.println("------");
    }



}
