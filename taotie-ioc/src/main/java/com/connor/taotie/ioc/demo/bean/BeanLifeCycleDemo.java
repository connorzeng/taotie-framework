package com.connor.taotie.ioc.demo.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean的生命周期
 */
public class BeanLifeCycleDemo {


    public static void main(String[] args) {

        // bean实例化
        initializationBean();

    }

    private static void initializationBean() {
        // 通过过静态方法实例化Persion.createPersion
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation-context.xml");

        System.out.println(context.getBean("persion-static-method"));
        System.out.println(context.getBean("persion-instance-factory"));

    }
}
