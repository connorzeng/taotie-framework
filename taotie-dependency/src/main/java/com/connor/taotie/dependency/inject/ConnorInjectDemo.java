package com.connor.taotie.dependency.inject;


import com.connor.taotie.dependency.annotation.ConnorAutowired;
import com.connor.taotie.dependency.annotation.ConnorInject;
import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * 自定义
 */
public class ConnorInjectDemo {

    //1. 替换内建对象  AnnotationConfigUtils
    //2. static 提前初始化 bean InstantiationAwareBeanPostProcessor

    @ConnorAutowired
    private Persion persion;

    @ConnorInject
    private Persion persionConnor;

    /**
     * 使用AutowiredAnnotationBeanPostProcessor增加AutowiredAnnotationTypes
     * 必须是static方法
     * @return
     */
    /*@Bean
    //@Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME) //并不是强制要求返回这个beanName
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor postProcessor = new AutowiredAnnotationBeanPostProcessor();

        Set<Class<? extends Annotation>> autowiredAnnotationTypes =
                new LinkedHashSet<>(Arrays.asList(Autowired.class, Value.class, ConnorInject.class));
        postProcessor.setAutowiredAnnotationTypes(autowiredAnnotationTypes);

        return postProcessor;
    }*/

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE - 3)
    @Scope
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        beanPostProcessor.setAutowiredAnnotationType(ConnorInject.class);
        return beanPostProcessor;
    }




    @Bean
    public Persion hello(){
        return new Persion("connorAutowiredze曾罡",3);
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ConnorInjectDemo.class);
        applicationContext.refresh();


        ConnorInjectDemo bean = applicationContext.getBean(ConnorInjectDemo.class);
        System.out.println(bean.persion);
        System.out.println(bean.persionConnor);

        applicationContext.close();
    }


}
