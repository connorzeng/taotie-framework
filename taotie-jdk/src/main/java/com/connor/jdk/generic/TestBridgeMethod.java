package com.connor.jdk.generic;

public class TestBridgeMethod {

    public static void main(String[] args) {

        SuperClass clazz = new SubClass();

        clazz.getObj("hello");

        //java.lang.ClassCastException: java.lang.Object cannot be cast to java.lang.String
        clazz.getObj(new Object());
    }
}
