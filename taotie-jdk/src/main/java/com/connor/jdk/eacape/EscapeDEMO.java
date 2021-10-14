package com.connor.jdk.eacape;

import com.connor.jdk.dto.User;

/**
 * 标量替换分配(聚合量)
 * User
 *  String name;
 *  String age;
 *  int age;
 *
 */
public class EscapeDEMO {


    //需要开启逃逸.
    //-XX:+DoEscapeAnalysis :开启逃逸分析（从JDK1.7开始默认开启）
    //-XX:-DoEscapeAnalysis :关闭逃逸分析
    //-XX:+PrintEscapeAnalysis
    // 开启逃逸分析, JVM会额外的跟踪对象.
    public static void main(String[] args) {
        //方法逃逸
        sayHello();


        //线程逃逸
        //如果没有线程,可以sync同步擦除.
        //兑现只有这一个线程在使用, 没有其他线程使用

    }

    private static void sayHello() {
        // User对象只在方法里面, 所以对象u会分配在栈里面.
        // user没有逃逸
        User u = new User();
        System.out.println(u.getAge());
    }
}
