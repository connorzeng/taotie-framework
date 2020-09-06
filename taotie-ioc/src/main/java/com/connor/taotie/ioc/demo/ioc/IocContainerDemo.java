package com.connor.taotie.ioc.demo.ioc;

import com.alibaba.fastjson.JSON;
import com.connor.common.tool.SpringTools;
import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 演示IOC的容器的使用
 */
@Configurable
public class IocContainerDemo {


    public static void main(String[] args) {

        // 演示1
        testAnnotationContainer();

        // 演示2
        testXmlContainer();
    }

    private static void testXmlContainer() {

        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // XML 配置文件 ClassPath 路径
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        // 加载配置
        int beanDefinitionsCount = reader.loadBeanDefinitions(location);
        System.out.println("Bean 定义加载的数量：" + beanDefinitionsCount);
        // 依赖查找集合对象
        SpringTools.lookupCollectionAll(beanFactory);
    }


    /**
     * AnnotationConfigApplicationContext
     */
    private static void testAnnotationContainer() {

        //新建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(IocContainerDemo.class);
        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println("Bean 定义加载的数量1：" + beanDefinitionCount);
        System.out.println("Bean 定义加载的名陈1：" + JSON.toJSONString(beanDefinitionNames));
        // 必须要refresh才能加载到persion
        applicationContext.refresh();
        beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println("Bean 定义加载的数量2：" + beanDefinitionCount);
        System.out.println("Bean 定义加载的名陈2：" + JSON.toJSONString(beanDefinitionNames));
        //遍历容器中的bean
        SpringTools.lookupCollectionAll(applicationContext);


        //关闭容器
        applicationContext.close();
    }

    @Bean
    public Persion persion(){
        Persion persion = new Persion();
        persion.setName("曾哥-annotion");
        persion.setAge(3);
        return persion;
    }

}
