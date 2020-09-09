package com.connor.common.tool;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 工具类
 */
public class SpringTools {


    /**
     * 获取容器中所有的bean
     *
     * @param beanFactory
     */
    public static Map<String, Object> lookupCollectionAll(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> beansOfType = listableBeanFactory.getBeansOfType(Object.class);
            beansOfType.forEach((name, bean) -> {
                System.out.println(name + ":" + bean.getClass().getName());
            });
            return beansOfType;
        }
        return null;
    }

    /**
     * 获取容器中的bean.不包括内建对象
     *
     * @param beanFactory
     */
    public static Map<String, Object> lookupCollectionTaotie(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> beansOfType = listableBeanFactory.getBeansOfType(Object.class);
            beansOfType.forEach((name, bean) -> {
                if (bean.getClass().getName().startsWith("com.connor")){
                    System.out.println(name + ":" + bean.getClass().getName());
                }
            });
            return beansOfType;
        }
        return null;
    }

    /**
     * 获取容器中所有的beanDefinition
     *
     * @param applicationContext
     */
    public static void logBeanDefinition(AnnotationConfigApplicationContext applicationContext) {

        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        System.out.println("beanDefinitionCount:" + beanDefinitionCount);
        System.out.println("beanDefinitionNames:" + JSON.toJSONString(beanDefinitionNames));
    }

    /**
     * 给容器注册beanDefinition
     *
     * @param applicationContext
     * @param name
     * @param clz
     */
    public static void registerPersionWithAPI(BeanDefinitionRegistry applicationContext, String name, Class clz) {

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clz)
                .addPropertyValue("name","曾罡-registerPersionWithAPI")
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
}

