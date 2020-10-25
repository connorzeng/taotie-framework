package com.connor.taotie.dependency.lifecycle;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

/**
 * 将properties解析成BeanDefinition
 */
public class PropertiesBeanDefinitionReaderDemo {


    public static void main(String[] args) {

        /**
         *  1. properties beandifition reader
         *  2. bean factory
         */
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        System.out.println("getBeanDefinitionCount-before:" + beanFactory.getBeanDefinitionCount());
        reader.loadBeanDefinitions(new EncodedResource(new ClassPathResource("META-INF/persion.properties"), "UTF-8"));
        System.out.println("getBeanDefinitionCount-after:" + beanFactory.getBeanDefinitionCount());

        // 加载完成后,直接获取;
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("persion");
        Object persion = beanFactory.getBean("persion");

        System.out.println(beanDefinition);
        System.out.println(persion);
    }

}
