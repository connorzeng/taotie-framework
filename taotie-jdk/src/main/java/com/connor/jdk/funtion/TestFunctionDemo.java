package com.connor.jdk.funtion;

import org.apache.dubbo.common.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 函数式编程
 */
public class TestFunctionDemo {

    public static void main(String[] args) {
        // function接口
        Function<String, String> function = (param) -> {
            System.out.println(param);
            return "hello,i am " + param;
        };
        System.out.println(function.apply("connor"));

        // predicate
        Predicate<String> predicate = (in) -> {
            if (StringUtils.isNoneEmpty(in)) {
                return true;
            }
            return false;
        };
        System.out.println(predicate.test(""));


        // consumer接口
        Consumer<String> consumer = (param) -> {
            System.out.println(param);
        };
        consumer.accept("connor");


        //suppler接口




        /**
         * 非常简洁的写法.
         */
        //foreach遍历map
        new HashMap<>().forEach((k,v)-> System.out.println(k+":"+v));

        //对于consumer接口能使用, method reference,
        //表现形式, 对象::方法
        ConnorObject connorObject = new ConnorObject();
        new ArrayList<>().forEach(connorObject::printObject);
        new ArrayList<>().forEach(System.out::println);
    }
}

class ConnorObject{

    void printObject(Object o){
        System.out.println(o);
    }

}