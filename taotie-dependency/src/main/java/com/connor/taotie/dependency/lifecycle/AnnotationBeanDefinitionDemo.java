package com.connor.taotie.dependency.lifecycle;


import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 测试: 直接注册一个正常的Bean class
 */
@Component
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);

        // 只会注册上AnnotationBeanDefinitionDemo, 不会注册@Bean 的persion
        reader.register(AnnotationBeanDefinitionDemo.class);


        Object object = beanFactory.getBean("annotationBeanDefinitionDemo");
        System.out.println(object);

        // 这里是会报错的.
        Object persion = beanFactory.getBean("persion");
        System.out.println(persion);
    }


    @Bean
    public Persion persion() {
        Persion persion = new Persion("曾哥", 120);
        return persion;
    }
}
