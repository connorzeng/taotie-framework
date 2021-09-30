package com.connor.jdk.funtion;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Optional接口
 *
 * Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 * Optional 类的引入很好的解决空指针异常。
 *
 */
public class OptianalDemo {


    public static void main(String[] args) {


        testFromCaiNiao();


        Map<String,User> userMap = new HashMap<>();

        User hello0 = Optional.of(userMap.get("connor")).orElse(new User("default"));


        // 如果为空,创建一个
        User hello = Optional.ofNullable(userMap.get("connor")).orElse(new User("default"));
        System.out.println(hello);


        // 如果为空,抛出异常
        User hello2 = Optional.ofNullable(userMap.get("connor")).orElseThrow(OptianalDemo::get);
        System.out.println(hello2);
    }

    private static void testFromCaiNiao() {
        OptianalDemo java8Tester = new OptianalDemo();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(java8Tester.sum(a,b));
    }

    private static RuntimeException get() {
        return new RuntimeException("不存在该用户");
    }


    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }
}

class User{

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
