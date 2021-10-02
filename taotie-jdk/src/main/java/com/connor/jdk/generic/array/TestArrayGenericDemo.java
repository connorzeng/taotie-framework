package com.connor.jdk.generic.array;

import java.util.Arrays;

public class TestArrayGenericDemo {


    public static void main(String[] args) {

        //ArrayStoreException: java.lang.String
        try {
            Object[] duck = new Integer[2];
            duck[0] = "hello";
        } catch (Exception e) {
            e.printStackTrace();
        }


        //数组泛型
        GenericArrayWithType<Integer> intArrays = new GenericArrayWithType<>(Integer.class, 3);
        intArrays.put(0,1);
        intArrays.put(1,2);
        intArrays.put(2,3);
        Arrays.stream(intArrays.rep()).forEach(System.out::println);
    }
}