package com.connor.jdk.jvm;

public class 常量池测试 {

    public static void main(String[] args) {
        //test intern
        String aa = "connor";//在JDK
        String bb = "connor";
        String cc = new String("connor");


        System.out.println(aa == bb);//false,,,,,这是true
        System.out.println(cc == aa);//false
        System.out.println(aa.equals(bb));//true
        System.out.println(aa.intern() == bb.intern());//true
        System.out.println(aa.intern() == cc.intern());//true


    }
}
