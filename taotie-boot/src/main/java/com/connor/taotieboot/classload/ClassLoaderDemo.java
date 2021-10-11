package com.connor.taotieboot.classload;

public class ClassLoaderDemo {

    //TODO  编写classloader
//https://blog.csdn.net/Ditto_zhou/article/details/79972240
    //
    public static void main(String[] args) {

        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(classLoader);//app

        System.out.println(classLoader.getParent());//ext

        System.out.println(classLoader.getParent().getParent());//boot


    }


}
