package com.connor.taotie.dependency.lookup;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试一个父子容器
 */
public class HierarchicalApplicationContextDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();

        // refresh放在这里和放在下面是不一样的效果.获取的persion会不一样
        // applicationContext.refresh();

        // 设置父容器
        DefaultListableBeanFactory parentBeanFactory = createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);
        System.out.println("parentBeanFactory:" + parentBeanFactory);
        System.out.println("beanFactory:" + beanFactory);

        System.out.println(parentBeanFactory.containsLocalBean("persion"));
        System.out.println(beanFactory.containsLocalBean("persion"));

        System.out.println(parentBeanFactory.getBean("persion"));
        System.out.println(beanFactory.getBean("persion"));
        System.out.println(beanFactory.getBean("superPersion"));

        applicationContext.refresh();;
        applicationContext.close();
    }


    /**
     * 创建parent BeanFactory
     *
     *
     * @return
     */
    private static DefaultListableBeanFactory createParentBeanFactory() {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        // 可以读到jar里面的xml
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");

        return beanFactory;
    }
}
