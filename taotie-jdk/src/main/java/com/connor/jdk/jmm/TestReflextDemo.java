package com.connor.jdk.jmm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestReflextDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<Connor> aClass = (Class<Connor>) Class.forName("com.connor.jdk.jmm.Connor");

        // 通过反射获取到私有的Construstor.
        Constructor<Connor> declaredConstructor = aClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Connor connor = declaredConstructor.newInstance();

        System.out.println(connor);
    }

}
class Connor{

    // 反射会破会private, 造成安全性问题.
    private Connor(){
        //需要在这里抛出异常
    }

    private String name = "connor";

    @Override
    public String toString() {
        return "Connor{" +
                "name='" + name + '\'' +
                '}';
    }
}