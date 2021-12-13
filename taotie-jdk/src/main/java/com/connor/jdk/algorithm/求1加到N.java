package com.connor.jdk.algorithm;


/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class 求1加到N {

    public static void main(String[] args) {
        System.out.println(1 >> 1);
        System.out.println(0 >> 1);

        //使用递归
        int result = addN(2);
        System.out.println(result);

        int result2 = addQuick(10);


//        System.out.println(12 & 7);
//        System.out.println(7 & 7);


        //快乘法
        multiply(100, 101);

    }

    private static int addQuick(int i) {

        int A = i;
        int B = i + 1;
        int ans = 0;
        boolean flag;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;


        return 0;
    }

    private static int multiply(int A, int B) {
        // A*B = A*B/2 + A*B/2      //B为偶数
        // A*B = A*B/2 + A*B/2 + A  //B为奇数

        //A*B = (A*B>>2) << 2 + A?
        if (B == 0) {
            return 0;
        }
        if (B == 1) {
            return A;
        }
        return (multiply(A, B >> 1) << 1) + ((B & 1) == 0 ? 0 : A);
    }

    private static int addN(int n) {

        if (n <= 0) {
            return 0;
        } else {
            return n + addN(n - 1);
        }
    }

}
