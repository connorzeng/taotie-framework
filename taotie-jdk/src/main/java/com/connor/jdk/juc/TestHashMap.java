package com.connor.jdk.juc;

public class TestHashMap {

    public static void main(String[] args) {

        // 槽位8, 对8(2^n)取模, 就是用hash值&2^n-1
        // 取模运算, 变成了位运算.
        int mod = 7;
        System.out.println(1 & mod);
        System.out.println(2 & mod);
        System.out.println(mod & mod);
        System.out.println(8 & mod);
        //---------------
        System.out.println(9 & mod);
        System.out.println(17 & mod);


        int newCap = 16;
        System.out.println(9 & 16);//0
        System.out.println(17 & 16);//16
        System.out.println(9 & newCap-1);//9
        System.out.println(17 & newCap-1);//1

        System.out.println("---------------------------");

        /**
         * 从数学上将，CPU中的ALU在算术上只干了两件事，加法，移位，顶多加上取反，在逻辑上，只有与或非异或。
         * 加法->加法。
         * 减法->取反，加法。
         * 乘法->移位，逻辑判断，累加
         * 除法->移位，逻辑判断，累减
         */
        System.out.println("---------------------------------------");
        //取模 = 整除取余, CPU的计算只有加法器, 循环相减.  1000000 对 8取模
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            long slot = 1000000000 % 32;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            long slot = 1000000000 & 31;
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
