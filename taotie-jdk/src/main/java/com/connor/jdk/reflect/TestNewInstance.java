package com.connor.jdk.reflect;

import com.connor.jdk.dto.User;

public class TestNewInstance {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        long start = System.currentTimeMillis();
        //使用new来创建对象 VS 使用反射Relfestion来创建对象
        for (int i = 0; i < 1000_000; i++) {

            //User user = new User();// 9 millis

            //User user = User.class.newInstance();//29 millis



            // 查找字节码.
            //
            Class.forName("com.connor.jdk.dto.User").newInstance();//922

        }
        long stop = System.currentTimeMillis();

        System.out.println(stop - start);
    }

}
