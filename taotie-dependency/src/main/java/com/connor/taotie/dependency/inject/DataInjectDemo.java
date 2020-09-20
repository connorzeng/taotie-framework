package com.connor.taotie.dependency.inject;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试List/Array
 */
public class DataInjectDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("classpath:META-INF/bean-inject.xml");
        applicationContext.refresh();

        System.out.println(applicationContext.getBean("persionHolderManu"));

        applicationContext.close();
    }
}
