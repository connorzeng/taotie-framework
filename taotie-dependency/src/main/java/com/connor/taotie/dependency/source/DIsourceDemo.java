package com.connor.taotie.dependency.source;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * 划重点: 游离对象不能进行依赖查找, 只能注入
 *
 * 依赖注入和依赖查找都有一个重要的前提就是: 依赖的来源
 * 1. BeanDefinition
 * -->依赖查找;依赖注入
 * 2. 单体对象
 * -->依赖查找;依赖注入
 * 3. resovableDependency 游离对象 可以被解决的对象
 * -->依赖注入;  NO DEPENDENCY QUERY
 */
public class DIsourceDemo {


    //四大外挂(游离)对象:
//    beanFactory == applicationContext false
//    beanFactory == applicationContext.getBeanFactory() true
//    resourceLoader == applicationContext true
//    ApplicationEventPublisher == applicationContext true
//    当前类型org.springframework.beans.factory.BeanFactory 无法在 BeanFactory 中查找!
//    当前类型org.springframework.context.ApplicationContext 无法在 BeanFactory 中查找!
//    当前类型org.springframework.core.io.ResourceLoader 无法在 BeanFactory 中查找!
//    当前类型org.springframework.context.ApplicationEventPublisher 无法在 BeanFactory 中查找!



    // 注入在 postProcessProperties 方法执行，早于 setter注入，也早于 @PostConstruct
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void initByInjection() {
        System.out.println("beanFactory == applicationContext " + (beanFactory == applicationContext));
        System.out.println("beanFactory == applicationContext.getBeanFactory() " + (beanFactory == applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("resourceLoader == applicationContext " + (resourceLoader == applicationContext));
        System.out.println("ApplicationEventPublisher == applicationContext " + (applicationEventPublisher == applicationContext));
    }

    @PostConstruct
    public void initByLookup() {
        getBean(BeanFactory.class);
        getBean(ApplicationContext.class);
        getBean(ResourceLoader.class);
        getBean(ApplicationEventPublisher.class);
    }

    private <T> T getBean(Class<T> beanType) {
        try {
            return beanFactory.getBean(beanType);
        } catch (NoSuchBeanDefinitionException e) {
            System.err.println("当前类型" + beanType.getName() + " 无法在 BeanFactory 中查找!");
        }
        return null;
    }


    public static void main(String[] args) {


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DIsourceDemo.class);
        applicationContext.refresh();


        //DIsourceDemo bean = applicationContext.getBean(DIsourceDemo.class);

        applicationContext.close();
    }


}
