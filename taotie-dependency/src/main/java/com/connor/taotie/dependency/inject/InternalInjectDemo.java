package com.connor.taotie.dependency.inject;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * 测试内建对象的注入
 * 测试注入的时间顺序
 * init sequence
 * @Autowired @PostConstruct
 *
 */
public class InternalInjectDemo {

    @Autowired
    private BeanFactory beanFactory;

    /**
     * ALL be ok
     * private static void init(){}<br/>
     * private void init(){}<br/>
     * public static void init(){}<br/>
     * public void init(){}<br/>
     */
    @PostConstruct
    public void init(){
        System.out.println("InternalInjectDemo-init");
        System.out.println(beanFactory);
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InternalInjectDemo.class);
        applicationContext.refresh();


        System.out.println(applicationContext.getBean(InternalInjectDemo.class));
        applicationContext.close();
    }
}
