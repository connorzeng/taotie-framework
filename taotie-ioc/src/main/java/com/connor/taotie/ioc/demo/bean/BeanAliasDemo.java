package com.connor.taotie.ioc.demo.bean;

import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 别名,别名获取的bean是同一个bean
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        // 通过别名 xiaomage-user 获取曾用名 user 的 bean
        Persion user = beanFactory.getBean("persionAlian", Persion.class);
        Persion xiaomageUser = beanFactory.getBean("persion", Persion.class);
        System.out.println("xiaomage-user 是否与 user Bean 相同：" + (user == xiaomageUser));
    }
}
