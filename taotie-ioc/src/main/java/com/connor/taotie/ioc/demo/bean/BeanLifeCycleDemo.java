package com.connor.taotie.ioc.demo.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean的生命周期
 */
public class BeanLifeCycleDemo {


    public static void main(String[] args) {

        // bean实例化-普通形式
        initializationBean();

        //bean实例化-特殊形式-serviceLoader


        //bean实例化-特殊形式-BeanDefinitionRegistry


        //bean实例化-特殊形式-AutowireCapableBeanFactory


    }

    private static void initializationBean() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation-context.xml");
        // 通过过静态方法实例化Persion.createPersion
        System.out.println(context.getBean("persion-static-method"));
        // 通过实例工厂
        System.out.println(context.getBean("persion-instance-factory"));
        // 通过BeanFactory

    }
}
