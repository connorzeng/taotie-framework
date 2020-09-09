package com.connor.taotie.ioc.demo.bean;

import com.connor.common.tool.SpringTools;
import com.connor.taotie.ioc.pojo.DefaultOtherPersionFactory;
import com.connor.taotie.ioc.pojo.DefaultPersionFactory;
import com.connor.taotie.ioc.pojo.Persion;
import com.connor.taotie.ioc.pojo.PersionFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * bean的实例化
 */
public class BeanInstanceDemo {


    public static void main(String[] args) {

        // bean实例化-普通形式
        initializationBean();

        //bean实例化-特殊形式-serviceLoader
        initializationBeanServiceLoader();
        initializationBeanServiceLoaderJAVA();

        //bean实例化-特殊形式-BeanDefinitionRegistry
        initializationBeanRegistry();

        //bean实例化-特殊形式-AutowireCapableBeanFactory
        initializationBeanAutowire();
    }



    private static void initializationBeanServiceLoader() {
        System.out.println("initializationBeanServiceLoader----------begin--------------");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation-special-context.xml");

        ServiceLoader<PersionFactory> persionFactoryServiceLoader = context.getBean("persionFactoryServiceLoader", ServiceLoader.class);

        Iterator<PersionFactory> iterator = persionFactoryServiceLoader.iterator();
        while (iterator.hasNext()){
            PersionFactory next = iterator.next();
            //System.out.println(PersionFactory.class.isInstance(next) + ";;;;;;;;;;");
            System.out.println(next.createPersion());
        }
    }


    private static void initializationBeanServiceLoaderJAVA() {
        System.out.println("initializationBeanServiceLoaderJAVA----------begin--------------");
        //不使用serviceLoader加载
        ServiceLoader<PersionFactory> serviceLoader = ServiceLoader.load(PersionFactory.class);
        for (PersionFactory myServiceLoader : serviceLoader){
            System.out.println(myServiceLoader.createPersion());
        }
    }


    private static void initializationBean() {
        System.out.println("initializationBean----------begin--------------");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation-context.xml");
        // 通过过静态方法实例化Persion.createPersion
        System.out.println(context.getBean("persion-static-method"));
        // 通过实例工厂
        System.out.println(context.getBean("persion-instance-factory"));
        // 通过BeanFactory
        System.out.println(context.getBean("persion-factory-bean"));

        context.close();
    }

    private static void initializationBeanAutowire() {

        System.out.println("initializationBeanAutowire----------begin--------------");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation-special-context.xml");

        AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();
        //Failed to instantiate [com.connor.taotie.ioc.pojo.PersionFactory]: Specified class is an interface
        //不能穿件接口
        //PersionFactory bean = autowireCapableBeanFactory.createBean(PersionFactory.class);
        PersionFactory bean = autowireCapableBeanFactory.createBean(DefaultOtherPersionFactory.class);
        System.out.println(bean.createPersion());
    }


    private static void initializationBeanRegistry() {
        System.out.println("initializationBeanRegistry----------begin--------------");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        SpringTools.registerPersionWithAPI(context, "persion-connorSystem", Persion.class);
        context.refresh();

        Persion bean = (Persion) context.getBean("persion-connorSystem");
        System.out.println(bean);
    }

}
