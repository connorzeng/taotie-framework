package com.connor.jdk.funtion;

import java.util.stream.Stream;

/**
 * Stream reduce
 */
public class TestStreamReduceDemo {

    public static void main(String[] args) {

        // 求和
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (acc, n) -> acc + n);
        System.out.println(sum); // 45


        // 求乘机.
        int i = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(1, (u1, u2) -> {
            return u1 * u2;
        }).intValue();
        System.out.println(i); //362880



    }
}
