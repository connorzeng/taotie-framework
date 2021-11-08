package com.connor.jdk;

import java.util.HashMap;

public class JdkTest {


    public static void main(String[] args) {


        /**
         * 基于Integer缓存机制  IngegerCache缓存-128~127
         */
        //Byte，Short，Long 的缓存池范围默认都是: -128 到 127
        Integer a = new Integer(100);
        Integer b = 100;
        int c = 100;
        Integer d=100;



        System.out.println("a == b:"+(a == b));
        System.out.println("a == c:"+(a == c));
        System.out.println("b == c:"+(b == c));
        System.out.println("b == d:"+(b == d));
        System.out.println("a="+System.identityHashCode(a));
        System.out.println("b="+System.identityHashCode(b));
        System.out.println("c="+System.identityHashCode(c));
        System.out.println("d="+System.identityHashCode(d));

        int aa = 1254;
        int bb = 1254;
        long aal = 12563;
        long bbl = 12563;
        float af = 1.0f;
        float bf = 1.0f;
        System.out.println(aa == bb);
        System.out.println(aal == bbl);
        System.out.println(af == bf);


        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();//必须是包装类
        hashMap.put(1,1);//被自动包装

        String astr = ";;";
        int i = astr.hashCode();

    }

}
