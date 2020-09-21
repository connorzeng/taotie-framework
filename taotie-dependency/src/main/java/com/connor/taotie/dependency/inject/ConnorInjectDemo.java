package com.connor.taotie.dependency.inject;


import com.connor.taotie.dependency.annotation.ConnorInject;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自定义
 */
public class ConnorInjectDemo {

    //TODO 自定义注解
    //1. 替换内建对象  AnnotationUtils
    //2. static 提前初始化 bean InstantiationAwareBeanPostProcessor





    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ConnorInjectDemo.class);
        applicationContext.refresh();



        System.out.println(applicationContext.getBean("persionHolderManu"));
        applicationContext.close();
    }


}
