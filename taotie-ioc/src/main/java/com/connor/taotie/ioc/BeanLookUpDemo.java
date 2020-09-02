package com.connor.taotie.ioc;


import com.connor.taotie.ioc.annotation.Super;
import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找demo
 */
public class BeanLookUpDemo {


    public static void main(String[] args) {
        //配置 XML 配置文件
        //启动 Spring上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        lookupRealTime(beanFactory);
        lookupLazyTime(beanFactory);
        lookupCollection(beanFactory);
        lookupAnnotation(beanFactory);
    }


    private static void lookupRealTime(BeanFactory beanFactory) {
        System.out.println("lookupRealTime--------------------");
        Persion bean = (Persion) beanFactory.getBean("persion");
        System.out.println(bean + ";" + bean.hashCode());
    }

    private static void lookupLazyTime(BeanFactory beanFactory) {
        //TODO 不太明白为什么是延迟查找
        System.out.println("lookupLazyTime--------------------");
        ObjectFactory<Persion> objectFactory = (ObjectFactory<Persion>) beanFactory.getBean("objectFactory");
        Persion bean = objectFactory.getObject();
        System.out.println(bean + ";" + bean.hashCode());
    }

    private static void lookupCollection(BeanFactory beanFactory) {
        System.out.println("lookUpCollection--------------------");
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Persion> beansOfType = listableBeanFactory.getBeansOfType(Persion.class);
            beansOfType.forEach((name, bean) -> {
                System.out.println(bean + ";" + bean.hashCode());
            });
        }
    }

    private static void lookupAnnotation(BeanFactory beanFactory) {

        System.out.println("lookupAnnotation--------------------");
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            // 这个注解是打到Persion类上面的
            Map<String, Persion> beansWithAnnotation = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            beansWithAnnotation.forEach((name, bean) -> {
                System.out.println(bean + ";" + bean.hashCode());
            });
        }
    }


}
