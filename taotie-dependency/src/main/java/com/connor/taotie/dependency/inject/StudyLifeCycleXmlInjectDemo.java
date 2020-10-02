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
 *  xml依赖注入的过程
 *  TODO xml注入过程
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
