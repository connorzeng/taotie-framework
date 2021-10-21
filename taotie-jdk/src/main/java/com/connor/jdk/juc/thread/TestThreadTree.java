package com.connor.jdk.juc.thread;

public class TestThreadTree {

    public static void main(String[] args) {

        Thread a = new Thread(()->{
            System.out.println("hello");
        });

        String name = a.getThreadGroup().getName();//main
        System.out.println(name);
    }
}
