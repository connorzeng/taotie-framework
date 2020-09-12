package com.connor.taotie.dependency.lookup;

import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 *
 * spring5.1以后提供的ObjectProvider-->ObjectFactory
 *
 * 特性
 *
 */
public class ObjectProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();



        // 获取流输出(对象)
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        beanProvider.stream().forEach(System.out::println);


        // getIfAvailable方法获取Persion,没有就创建
        ObjectProvider<Persion> persionObjectProvider = applicationContext.getBeanProvider(Persion.class);
        Persion persion = persionObjectProvider.getIfAvailable(Persion::createPersion);
        System.out.println(persion);


        // 如果没有primary标签,这里会报错.但是上面不会
        System.out.println(beanProvider.getObject());
        applicationContext.close();
    }


    @Bean
    @Primary
    public String helloworld() {
        return "helloworldStr";
    }

    @Bean
    public String helloworld1() {
        return "helloworldStr1";
    }

    @Bean
    public Persion persion(){
        return new Persion("曾罡-ObjectProviderDemo",1);
    }
}
