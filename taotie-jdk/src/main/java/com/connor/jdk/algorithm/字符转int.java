package com.connor.jdk.algorithm;

import java.io.UnsupportedEncodingException;

public class 字符转int {

    /**
     * 内码：程序内部使用的字符编码，如java的char，所以java的char是2字节16位；
     * 外码：程序外部交互时使用的字符编码，如class文件。
     */
    /**
     * 给定一个字符串,
     * @param args
     */
    public static void main(String[] args) throws UnsupportedEncodingException {

//        int zero = '0';
//        int nine = '9';
//        System.out.println(zero);
//        System.out.println(nine - zero);//9

        // 正常的
        String numStr1 = "-123";
        String numStr2 = "+123";
        String numStr3 = "123.00000";//包含很多个0

        // 非法字符
        //"+","-","123.01","a*",null
        //溢出的字符
        int result = revertStrToStr(numStr1);
        System.out.println(result);
    }

    private static int revertStrToStr(String numStr1) {
        long sum = 0;
        //判断非法
        if (numStr1 == null || numStr1.isEmpty()){
            throw new RuntimeException("字符串不能为空");
        }

        int sign = 1;
        int index = 0;
        //"-123"
        //判断首位+-
        char first = numStr1.charAt(0);
        if (first == '-'){
            sign = -1;
            index ++;
        } else if (first == '+'){
            sign = 1;
            index ++;
        }

        //1
        //10  + 2
        //120 + 3
        while (index < numStr1.length()){
            //char numChar = numStr1.charAt(index);
            if (numStr1.charAt(index) < '0' || numStr1.charAt(index) > '9'){
                break;//面试官,这里你要怎么样
            }
            int value = numStr1.charAt(index) - '0';
            sum = sum * 10 + value;

            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
                break;//面试官,这里你要怎么样
            }
            index++;
        }
        return (int) sum * sign;
    }
}
