package com.connor.taotie.dependency.inject;


import com.connor.common.constants.City;
import com.connor.taotie.ioc.pojo.Persion;
import com.connor.taotie.ioc.pojo.SuperPersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

/**
 *  依赖注入的过程
 * - 入口-DefaultListableBeanFactory.resolveDependency
 * - 元信息: DependencyDescriptor
 * - 自动绑定候选对象处理器-AutowireCandidateResolver
 *
 */
public class StudyLifeCycleAnnotationInjectDemo {


    /**
     * Lazy标签的是
     */
    @Autowired
    @Lazy
    @Qualifier("persion1")
    private  Persion persion;

    /**
     *
     * Optional jdk
     * 相当于required = false
     */
    @Autowired
    private Optional<SuperPersion> persionOptional;



    public static void main(String[] args) {


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setId("connor_app_01");
        applicationContext.setDisplayName("connor_app");
        applicationContext.register(StudyLifeCycleAnnotationInjectDemo.class);
        applicationContext.refresh();

        StudyLifeCycleAnnotationInjectDemo bean = applicationContext.getBean(StudyLifeCycleAnnotationInjectDemo.class);

        System.out.println(bean.persion);
        System.out.println(bean.persionOptional);
        System.out.println("--------------------------");

        System.out.println(applicationContext.getId());
        System.out.println(applicationContext.getApplicationName());
        System.out.println(applicationContext.getDisplayName());
        System.out.println(applicationContext.getParent());
        System.out.println(applicationContext.getAutowireCapableBeanFactory());

        System.out.println(applicationContext.getAutowireCapableBeanFactory() == applicationContext.getBeanFactory());
        System.out.println(applicationContext.getAutowireCapableBeanFactory() == applicationContext.getDefaultListableBeanFactory());

        applicationContext.close();
    }


    @Bean("persion1")
    //@Primary
    public Persion persion1(){
        Persion persion = new Persion("connor-persion1", 1);
        persion.setCity(City.Guangzhou);
        return persion;
    }

    @Bean("persion2")
    public Persion persion2(){
        Persion persion = new Persion("connor-persion2", 1);
        persion.setCity(City.Guangzhou);
        return persion;
    }


}
