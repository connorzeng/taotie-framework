package com.connor.taotie.dependency.scope;


import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.annotation.PreDestroy;
import java.util.Map;

/**
 * prototype是不能纳入beanFactoryz生命周期管理的.需要要额外的手段进行.
 * 1. 所有生成的prototype进行手动管理
 * 2. 容器关闭时,手动吊起销毁方法
 *
 */
public class PrototypeScopeDemo {

    @Autowired
    @Qualifier("persionSingle")
    private Persion persionSingle;

    @Autowired
    @Qualifier("persion")
    private Persion persion1;

    @Autowired
    @Qualifier("persion")
    private Persion persion2;

    @Autowired
    @Qualifier("persion")
    private Persion persion3;

    @Autowired
    private Map<String, Persion> persions;

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    /**
     * 销毁
     */
    @PreDestroy
    public void destory(){

        /**
         * 如果不调用applicationContext.close(); 将不会调用这个方法.
         */

        // 自己管理多列销毁
        persion1.destory();
        persion2.destory();
        persion3.destory();

        // 自己管理集合注入中的多列销毁
        // 会注入两个对象: singletonPersion prototypePersion,需要手动进行销毁
        for (Map.Entry<String, Persion> entry : this.persions.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            if (beanDefinition.isPrototype()) { // 如果当前 Bean 是 prototype scope
                Persion user = entry.getValue();
                user.destory();
            }
        }
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(PrototypeScopeDemo.class);


        // 添加addBeanFactoryPostProcessor
        applicationContext.addBeanFactoryPostProcessor(PrototypeScopeDemo::postProcessBeanFactory);
        applicationContext.refresh();


        PrototypeScopeDemo bean = applicationContext.getBean(PrototypeScopeDemo.class);
        System.out.println(bean.persionSingle);
        System.out.println(bean.persion1);
        System.out.println(bean.persion2);
        System.out.println(bean.persion3);


        // 关闭容器
        applicationContext.close();
    }


    /**
     *
     * @param beanFactory
     */
    private static void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        System.out.println("addBeanFactoryPostProcessor-connor");
        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.printf("%s Bean 名称:%s 在初始化前回调...%n", bean.getClass().getName(), beanName);
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.printf("%s Bean 名称:%s 在初始化后回调...%n", bean.getClass().getName(), beanName);
                return bean;
            }
        });
    }


    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Persion persion() throws InterruptedException {
        Persion persion = new Persion();
        persion.setName("大缸子-prototype测试");
        persion.setAge(1);
        Thread.sleep(1);
        persion.setId(System.currentTimeMillis());
        return persion;
    }

    @Bean
    public Persion persionSingle() throws InterruptedException {
        Persion persion = new Persion();
        persion.setName("大缸子-persionSingle测试");
        persion.setAge(1);
        return persion;
    }
}
