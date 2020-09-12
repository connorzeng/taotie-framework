package com.connor.taotie.dependency.lookup;

import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class LookUpBeanExceptionDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(LookUpBeanExceptionDemo.class);
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();


        // BeanInstantiationException
        // BeanCreationException
        // spring不能创建接口
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class);
//        applicationContext.registerBeanDefinition("charSequence",beanDefinitionBuilder.getBeanDefinition());

        // BeanCreationException
        // Caused by: java.lang.Exception: for purposes...
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Pojo.class);
//        applicationContext.registerBeanDefinition("pojo", beanDefinitionBuilder.getBeanDefinition());


        applicationContext.refresh();
        System.out.println(beanFactory.getBean("helloworld"));
        System.out.println(beanFactory.getBean("persion"));

        try {
            //NoUniqueBeanDefinitionException
            String bean = beanFactory.getBean(String.class);
        } catch (BeansException e) {
            e.printStackTrace();
        }


        try {
            //NoSuchBeanDefinitionException
            System.out.println(beanFactory.getBean("persion1"));
        } catch (BeansException e) {
            e.printStackTrace();
        }


        applicationContext.close();
    }

    static class Pojo implements InitializingBean {


        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("for purposes...");
        }
    }

    @Bean
    @Primary //NoUniqueBeanDefinitionException
    public String helloworld() {
        return "helloworldStr";
    }

    @Bean
    public String helloworld1() {
        return "helloworldStr1";
    }

    @Bean
    public Persion persion() {


        return new Persion("曾罡-ObjectProviderDemo", 1);
    }

}
