package com.connor.taotie.dependency.lifecycle;


import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

/**
 * 测试bean的合并
 */
public class BeanDefinitionMegerDemo {

    //classpath:META-INF/dependency-lookup-context.xml
    public static void main(String[] args) {

        //1. beanFactory
        //2. xmlBeanDefinitionReader
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        System.out.println("getBeanDefinitionCount-before:" + beanFactory.getBeanDefinitionCount());
        reader.loadBeanDefinitions(new EncodedResource(new ClassPathResource("META-INF/dependency-lookup-context.xml")));
        System.out.println("getBeanDefinitionCount-after:" + beanFactory.getBeanDefinitionCount());

        BeanDefinition persionBD = beanFactory.getBeanDefinition("persion");
        BeanDefinition superPersionBD = beanFactory.getBeanDefinition("superPersion");
        System.out.println(superPersionBD);


        //3. 在查找bean的时候才会触发 getBean-->doGetBean --> mergeBeanDefinition(第一次完成合并后会放入缓存)(经过合并后变成RootBeanDefinition)
        Persion persion = (Persion) beanFactory.getBean("persion");


    }

}
