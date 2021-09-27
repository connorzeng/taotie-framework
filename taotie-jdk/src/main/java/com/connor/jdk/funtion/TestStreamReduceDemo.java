package com.connor.jdk.funtion;

import java.util.stream.Stream;

/**
 * Stream reduce
 */
public class TestStreamReduceDemo {

    public static void main(String[] args) {
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (acc, n) -> acc + n);
        System.out.println(sum); // 45
    }
}
