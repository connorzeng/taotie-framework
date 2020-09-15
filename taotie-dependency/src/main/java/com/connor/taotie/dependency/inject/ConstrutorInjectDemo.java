package com.connor.taotie.dependency.inject;

import com.connor.taotie.dependency.pojo.PersionHolder;
import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 测试构造器注入的DEMO
 */
public class ConstrutorInjectDemo {


    public static void main(String[] args) {


        //使用XML注入
        constructInjectByXml();

        //使用annotation注入
        constructInjectByAnnotation();
    }

    private static void constructInjectByXml() {
        System.out.println("constructInjectByXml---------------------");
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        // 读取BeanDefinition的source
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(configApplicationContext);
        reader.loadBeanDefinitions("classpath:META-INF/dependency-lookup-context.xml");
        reader.loadBeanDefinitions("classpath:META-INF/bean-inject-contructor.xml");
        configApplicationContext.refresh();

        System.out.println(configApplicationContext.getBean("persionHolderByConstructor"));
        System.out.println(configApplicationContext.getBean("persionHolderAutoByConstructor"));


        configApplicationContext.close();



    }

    /**
     * 这个注解的构造器注入没有什么意思
     */
    private static void constructInjectByAnnotation() {
        System.out.println("constructInjectByAnnotation---------------------");

        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(ConstrutorInjectDemo.class);
        // 读取BeanDefinition的source
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(configApplicationContext);
        reader.loadBeanDefinitions("classpath:META-INF/dependency-lookup-context.xml");
        configApplicationContext.refresh();

        System.out.println(configApplicationContext.getBean("persionHolder"));


        configApplicationContext.close();
    }

    @Bean
    public PersionHolder persionHolder(Persion persion){
        return new PersionHolder(persion);
    }
}
