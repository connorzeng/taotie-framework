package com.connor.taotie.dependency.inject;


import com.connor.common.constants.City;
import com.connor.taotie.ioc.pojo.Persion;
import com.connor.taotie.ioc.pojo.SuperPersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

/**
 *  依赖注入的过程
 * - 入口-DefaultListableBeanFactory.resolveDependency
 * - 元信息: DependencyDescriptor
 * - 自动绑定候选对象处理器-AutowireCandidateResolver
 * TODO 这里是要学习XML注入的过程,还没进行测试
 *
 */
public class StudyLifeCycleXmlInjectDemo {



    public static void main(String[] args) {


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("classpath:META-INF/bean-inject.xml");
        applicationContext.refresh();



        System.out.println(applicationContext.getBean("persionHolderManu"));
        applicationContext.close();
    }



}
