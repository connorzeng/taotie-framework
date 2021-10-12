package com.connor.jdk.classloader;

public class ClassLoaderDemo {

    //TODO  编写classloader
//https://blog.csdn.net/Ditto_zhou/article/details/79972240
//https://www.jianshu.com/p/69c4526b843d
    // tomcat打破的双亲委派只是在tomcat classloader关系这一层. 在JVM的calssloader还是遵循双亲委派
    //
    public static void main(String[] args) {

        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(classLoader);//app

        System.out.println(classLoader.getParent());//ext

        System.out.println(classLoader.getParent().getParent());//boot


    }


}
