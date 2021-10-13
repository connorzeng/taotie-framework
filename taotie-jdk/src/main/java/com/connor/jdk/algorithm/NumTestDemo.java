package com.connor.jdk.algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class NumTestDemo {


    public static void main(String[] args) {

        //返回tables中两个数相加等于指定数的, 两个下标.
        int[] ints = sumResult(new int[]{1, 3, 3, 1, 3, 8}, 9);
        Arrays.stream(ints).forEach(System.out::println);


        //返回斐波那契数第n个值,n从0开始
        //0,1,1,2,3,5,8,13
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));



    }

    private static int fib(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }


    /**
     * 返回tables中两个数相加等于指定数的, 两个下标.
     *
     * @param tables
     * @param sum
     * @return
     */
    private static int[] sumResult(int[] tables, int sum) {

        //基于HashMap来时实现.
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];
        for (int i = 0; i < tables.length; i++) {
            map.put(tables[i], i);
        }

        for (int i = 0; i < tables.length; i++) {
            int cur = tables[i];
            int other = sum - cur;
            if (map.containsKey(other)) {
                int otherIndex = map.get(other);
                if (otherIndex != i) {
                    result[0] = i;
                    result[1] = otherIndex;
                    return result;
                }
            }
        }


        return null;
    }


}
