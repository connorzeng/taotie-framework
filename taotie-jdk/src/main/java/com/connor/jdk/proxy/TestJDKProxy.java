package com.connor.jdk.proxy;

import java.lang.reflect.Proxy;

public class TestJDKProxy {

    public static void main(String[] args) {


        ConnorService connorService = (ConnorService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{ConnorService.class}, new ConnorProxy());



        connorService.sayHello();
    }
}
