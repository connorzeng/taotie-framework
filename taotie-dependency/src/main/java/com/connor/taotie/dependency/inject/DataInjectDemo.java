package com.connor.taotie.dependency.inject;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

/**
 * 测试List/Array
 */
public class DataInjectDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        StandardEnvironment environment = new StandardEnvironment();
        environment.setActiveProfiles("dev","ft");
        applicationContext.setEnvironment(environment);

        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("classpath:META-INF/bean-inject.xml");
        applicationContext.refresh();

        System.out.println(applicationContext.getBean("persionHolderManu"));

        applicationContext.close();
    }
}
