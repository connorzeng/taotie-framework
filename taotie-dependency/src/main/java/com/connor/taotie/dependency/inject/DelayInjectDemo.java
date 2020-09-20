package com.connor.taotie.dependency.inject;


import com.connor.taotie.ioc.pojo.Persion;
import com.sun.tracing.ProviderFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

/**
 * 延迟注入使用
 * ObjectProvider
 * ObjectFactory
 */
public class DelayInjectDemo {


    @Autowired
    private Persion persion;

    @Autowired
    private ObjectProvider<Persion> persionObjectProvider;

    @Autowired
    private ObjectFactory<Set<Persion>> persionObjectFacotry;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DelayInjectDemo.class);
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        beanDefinitionReader.loadBeanDefinitions("classpath:META-INF/bean-inject.xml");
        applicationContext.refresh();

        DelayInjectDemo bean = applicationContext.getBean(DelayInjectDemo.class);
        //System.out.println(bean.persion == bean.persionObjectProvider.getIfAvailable(()-> Persion.createPersion()));
        System.out.println(bean.persion == bean.persionObjectProvider.getIfAvailable(Persion::createPersion));

        System.out.println("persionObjectFacotry------------------");
        bean.persionObjectFacotry.getObject().forEach(System.out::println);


        applicationContext.close();

    }
}
