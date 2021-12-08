package com.connor.jdk.algorithm;

import java.io.UnsupportedEncodingException;

public class 字符编码测试 {

    //-Dfile.encoding
    // 内码是程序内部使用的字符编码，特别是某种语言实现其char或String类型在内存里用的内部编码；外码是程序与外部交互时外部使用的字符编码。
    // 外码和操作系统的系统是什么编码, JDK参数是什么编码, 程序中指定编码格式.
    public static void main(String[] args) throws UnsupportedEncodingException {

        testEncoder();


        System.out.println("----------------------------------------------");

        int a = (int) '1';
        int b = (int) '年';
        System.out.println(a);
        System.out.println(b);

        char c='编';  // 我们都知道c占用2个字节，这毫无疑问。
        String str="编";
        byte[] bytes=str.getBytes("UTF-16"); //这个打印出来，在不同的操作系统上可能有不同的长度。为什么呢？
        byte[] bytes2=str.getBytes("UTF-16BE"); //这个打印出来，在不同的操作系统上可能有不同的长度。为什么呢？
        byte[] bytes3=str.getBytes("UTF-16LE"); //这个打印出来，在不同的操作系统上可能有不同的长度。为什么呢？
        System.out.println(bytes.length);
        System.out.println(bytes2.length);
        System.out.println(bytes3.length);


        // ------------- char的定义和打印(基本多语言面字符)------------------
        char codeUnit = 'A';
        System.out.println(codeUnit); // A
        codeUnit = '\u0041'; // 直接用'A'的16进制表示来定义char变量的值，等价同上
        System.out.println(codeUnit); // A
        codeUnit = '€';
        System.out.println(codeUnit); // €
        codeUnit = '\u20AC';
        System.out.println(codeUnit); // €

        // ------------- char的定义和打印(增补字符)------------------
        //分别定义一个增补字符的前一个CodeUnit和后一个CodeUnit
        char codeUnit1 = '\uD801', codeUnit2 = '\uDC00';
        System.out.println(codeUnit1); // ?
        System.out.println(codeUnit2); // ?，无论是前面的CodeUnit还是后面的CodeUnit都只是部分，不构成完整字符，所以无法打印
        String tempStr = "" + codeUnit1 + codeUnit2;// 可以将两个CodeUnit拼接到一个字符串中，就能够正常打印了。
        System.out.println(tempStr);// 𐐀

        // ------------- CodePoint的打印------------------
        //CodePoint就是一个数字
        int codePoint = 0x0041;
        //%0#6X表示16进制格式，带前缀0X输出定长6位，不足前补0；%c表示打印一个CodePoint
        System.out.printf("Code point %0#6X is encoded for %c.%n", codePoint, codePoint);// Code point 0X0041 is encoded for A.
        codePoint = 0x10400;
        System.out.printf("Code point %0#6X is encoded for %c.%n", codePoint, codePoint);// Code point 0X10400 is encoded for 𐐀.

        // ------------- CodePoint中包含的CodeUnit打印------------------
        char [] cpchs = Character.toChars(codePoint);
        System.out.printf("In JVM inner representation(UTF-16), code point %0#6X contains code unit %0#6X and %0#6X .%n", codePoint, (int)cpchs[0], (int)cpchs[1]);// In JVM inner representation(UTF-16), code point 0X10400 contains code unit 0XD801 and 0XDC00.



    }

    private static void testEncoder() throws UnsupportedEncodingException {

        String s = "你好哦!";
        System.out.println( new String(s.getBytes(),"GBK"));
        //因为getBytes()默认使用GBK编码， 而解析时使用UTF-8编码，肯定出错。

        String chinese = "中文";//java内部编码
        String gbkChinese = new String(chinese.getBytes("GBK"),"ISO-8859-1");//转换成gbk编码
        //通过内码获取GBK编码, 再用GBK来反序列化就不会有问题.
        String gbkChinese2 = new String(chinese.getBytes("GBK"),"GBK");//转换成gbk编码


        String unicodeChinese = new String(gbkChinese.getBytes("ISO-8859-1"),"GBK");//java内部编码
        System.out.println(unicodeChinese);//中文
        String utf8Chinese = new String(unicodeChinese.getBytes("UTF-8"),"ISO-8859-1");//utf--8编码
        System.out.println(utf8Chinese);//乱码
        unicodeChinese = new String(utf8Chinese.getBytes("ISO-8859-1"),"UTF-8");//java内部编码
        System.out.println(unicodeChinese);//中文
    }
}
