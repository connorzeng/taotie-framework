package com.connor.taotie.dependency.source;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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





    public static void main(String[] args) {


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DIsourceDemo.class);
        applicationContext.refresh();

        DIsourceDemo bean = applicationContext.getBean(DIsourceDemo.class);



        applicationContext.close();
    }


}
