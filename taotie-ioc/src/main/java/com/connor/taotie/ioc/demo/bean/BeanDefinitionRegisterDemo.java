package com.connor.taotie.ioc.demo.bean;

import com.connor.common.tool.SpringTools;
import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
        registerPersionWithAPI(applicationContext, "persion-connorSystem");
        registerPersionWithAPI(applicationContext, null);


        //可以获取beanFactory注册一个单例bean
        //ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        //ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        //beanFactory.registerSingleton();
        applicationContext.refresh();


        //applicationContext.registerBeanDefinition("");
        SpringTools.lookupCollectionTaotie(applicationContext);
        SpringTools.logBeanDefinition(applicationContext);
    }

    private static void registerPersionWithAPI(AnnotationConfigApplicationContext applicationContext, String name) {

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Persion.class)
                .addPropertyValue("name","曾罡-api")
                .addPropertyValue("age",1)
                .setScope(BeanDefinition.SCOPE_SINGLETON);

        if (!StringUtils.isEmpty(name)){
            applicationContext.registerBeanDefinition(name, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // generateBeanName只是生成beanName,不会注册beanDefinition
            // BeanDefinitionReaderUtils.generateBeanName(beanDefinitionBuilder.getBeanDefinition(),applicationContext);
            // com.connor.taotie.ioc.pojo.Persion#0
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),applicationContext);
        }
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
    }

}
