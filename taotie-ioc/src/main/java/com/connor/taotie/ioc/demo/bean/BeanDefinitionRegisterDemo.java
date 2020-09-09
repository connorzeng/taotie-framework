package com.connor.taotie.ioc.demo.bean;

import com.connor.common.tool.SpringTools;
import com.connor.taotie.ioc.pojo.DefaultPersionFactory;
import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * bean的注册
 */
@Import(BeanDefinitionRegisterDemo.Config.class)
public class BeanDefinitionRegisterDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //都可以注册到Persion
        //AnnotationConfigApplicationContext 聚合了 AnnotatedBeanDefinitionReader 进来注册
        //applicationContext.register(Config.class);
        applicationContext.register(BeanDefinitionRegisterDemo.class);

        //使用API注册beanDefinition
        SpringTools.registerPersionWithAPI(applicationContext, "persion-connorSystem", Persion.class);
        SpringTools.registerPersionWithAPI(applicationContext, null, Persion.class);


        //可以获取beanFactory注册一个单例bean
        //ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        //ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        //beanFactory.registerSingleton();
        applicationContext.refresh();


        //applicationContext.registerBeanDefinition("");
        SpringTools.lookupCollectionTaotie(applicationContext);
        SpringTools.logBeanDefinition(applicationContext);
    }


    // 2. 通过 @Component 方式
    @Component // 定义当前类作为 Spring Bean（组件）
    public static class Config {

        @Bean
        public Persion persion() {
            Persion persion = new Persion();
            persion.setAge(1);
            persion.setName("曾罡-BeanDefinitionRegisterDemo");
            return persion;
        }

        @Bean
        public DefaultPersionFactory defaultPersionFactory() {
            return new DefaultPersionFactory();
        }
    }

}
