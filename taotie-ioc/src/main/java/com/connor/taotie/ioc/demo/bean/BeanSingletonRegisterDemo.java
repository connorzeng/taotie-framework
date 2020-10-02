package com.connor.taotie.ioc.demo.bean;

import com.connor.taotie.ioc.pojo.DefaultOtherPersionFactory;
import com.connor.taotie.ioc.pojo.PersionFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于spring singleton register管理bean
 */
public class BeanSingletonRegisterDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.refresh();

        // BeanFactory在Spring中只有两个默认实现: XmlBeanFactory已经废弃
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        DefaultListableBeanFactory defaultListableBeanFactory = applicationContext.getDefaultListableBeanFactory();
        // 是同一个beanFacotory
        System.out.println(beanFactory == defaultListableBeanFactory);

        PersionFactory persionFactory = new DefaultOtherPersionFactory();
        defaultListableBeanFactory.registerSingleton("persionFactory", persionFactory);
        System.out.println(persionFactory == applicationContext.getBean("persionFactory"));

        applicationContext.close();
    }
}
