package com.connor.taotie.ioc;

import com.connor.taotie.ioc.pojo.PersionRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 测试依赖注入
 */
public class BeanInjectionDemo {


    public static void main(String[] args) {

        testOne();

        testTwo();

    }


    private static void testOne() {
        System.out.println("testOne-------------------------");
        //配置 XML 配置文件
        //启动 Spring上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/injection-context.xml");

        //获取注入的对象PersionRepository
        // 依赖来源一：自定义bean
        PersionRepository persionRepository = beanFactory.getBean("repository", PersionRepository.class);
        System.out.println("persionRepository = " + persionRepository);

        //获取内建对象beanFactory
        //这两个不是同一个对象
        System.out.println("beanFactory:" + beanFactory);
        System.out.println("beanFactroy:" + persionRepository.getBeanFactory());
    }

    private static void testTwo() {
        System.out.println("testTwo-------------------------");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/injection-context.xml");

        PersionRepository persionRepository = applicationContext.getBean("repository", PersionRepository.class);

        //ClassPathXmlApplicationContext
        System.out.println("beanFactory:" + applicationContext);
        //DefaultListableBeanFactory
        System.out.println("beanFactroy:" + persionRepository.getBeanFactory());
        ApplicationContext applicationContext1 = persionRepository.getObjectFactory().getObject();
        System.out.println("applicationContext1:" + applicationContext1);

        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);
    }
}
