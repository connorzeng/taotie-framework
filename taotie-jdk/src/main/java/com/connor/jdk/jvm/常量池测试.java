package com.connor.jdk.jvm;

import java.util.Base64;

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



        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";//字面量
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;//

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // true
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s9);  // false
        System.out.println("s1==s5 " + Boolean.toString( s1 == s5));


        String s33 = new String("1") + new String("1");//据说在JDK1.7相等
//        String s33 = "1"+"1";
//        String s33t1 = "1";
//        String s33t2= "1";
//        String s33 = s33t1 + s33t2;
        //String s44 = "11"; s44 = s33.intern();//false
        String s44 = s33.intern();//true
        System.out.println(s33 == s44);



        //test
        test();
    }

    private static void test() {


        String aa = "a";
        String param = new String("param" + aa);
        String paramSame = param.intern();
        System.out.println(param == paramSame);

        //
        String s1 = "古时的风筝";
        String s2 = "古时的风筝";
        String a = "古时的";

        String s3 = new String(a + "风筝");
        String s4 = new String(a + "风筝");
        System.out.println(s1 == s2); // 【1】 true
        System.out.println(s2 == s3); // 【2】 false
        System.out.println(s3 == s4); // 【3】 false
        s3.intern();
        System.out.println(s2 == s3); // 【4】 false
        s3 = s3.intern();
        System.out.println(s2 == s3); // 【5】 true
        s4 = s4.intern();
        System.out.println(s3 == s4); // 【6】 true
    }
}
