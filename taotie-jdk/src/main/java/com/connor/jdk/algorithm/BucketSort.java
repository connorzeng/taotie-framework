package com.connor.jdk.algorithm;


import java.math.BigDecimal;

/**
 * 桶排序
 */
public class BucketSort {


    public static void main(String[] args) {
        //BigDecimal 的比较
        BigDecimal bigDecimal = new BigDecimal(1);
        BigDecimal bigDecimal1 = new BigDecimal(1);
        System.out.println(bigDecimal.equals(bigDecimal1));

        BigDecimal bigDecimal2 = new BigDecimal(1);
        BigDecimal bigDecimal3 = new BigDecimal(1.0);
        System.out.println(bigDecimal2.equals(bigDecimal3));

        BigDecimal bigDecimal4 = new BigDecimal("1");
        BigDecimal bigDecimal5 = new BigDecimal("1.0");
        System.out.println(bigDecimal4.equals(bigDecimal5));
        //scale = 38  intVal = 112345678901234567901234567890123456789
        BigDecimal bigDecimal6 = new BigDecimal("1.12345678901234567901234567890123456789");

        System.out.println(bigDecimal6);

        //


    }


}
