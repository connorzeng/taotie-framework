package com.connor.taotie.dependency.inject;


import com.connor.taotie.dependency.pojo.PersionHolder;
import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 使用setter进行注入
 */
public class SetterInjectDemo {

    public static void main(String[] args) {

        // 使用XML的方式来进行
        // setterDemoByXmlWay();

        // 使用annotation的方式来进行
        setterDemoByannotation();
    }


    private static void setterDemoByXmlWay() {
        // 声明一个beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 读取BeanDefinition的source
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:META-INF/bean-inject.xml");


        // 获取bean
        System.out.println(beanFactory.getBean("persionHolderManu"));
        // byName只要名字不重复即可
        System.out.println(beanFactory.getBean("persionHolderAutoByName"));
        // byType必须配置primary  No bean named 'persionHolderAutoByType' available
        System.out.println(beanFactory.getBean("persionHolderAutoByType"));
    }

    private static void setterDemoByannotation() {

        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(SetterInjectDemo.class);
        // 读取BeanDefinition的source
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(configApplicationContext);
        reader.loadBeanDefinitions("classpath:META-INF/dependency-lookup-context.xml");
        configApplicationContext.refresh();

        System.out.println(configApplicationContext.getBean("persionHolder"));


        configApplicationContext.close();
    }


    // 这里非常神奇,
    @Bean
    public PersionHolder persionHolder(Persion persion){
        PersionHolder persionHolder = new PersionHolder();
        persionHolder.setPersion(persion);
        return persionHolder;
    }

}
