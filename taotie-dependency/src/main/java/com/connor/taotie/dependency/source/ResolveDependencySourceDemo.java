package com.connor.taotie.dependency.source;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 演示外挂对象的注入.
 * 1. 注册外挂对象
 * 2. 通过beanFactoryPostProcesser在容器启动时注册
 * 3. 启动后进行注入
 */
public class ResolveDependencySourceDemo {

    @Autowired
    private String name;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolveDependencySourceDemo.class);

        // 方案一: 需要在容器启动前注册resolvableDependency
//        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
//        beanFactory.registerResolvableDependency(String.class, "大缸子老师");

        // 方案二: 需要在容器启动过程中配置beanFactoryPostProcesser
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerResolvableDependency(String.class,"大缸子老师");
        });

        // 启动容器
        applicationContext.refresh();

        // 获取Bean
        ResolveDependencySourceDemo bean = applicationContext.getBean(ResolveDependencySourceDemo.class);
        System.out.println(bean.name);

        applicationContext.close();
    }

}
