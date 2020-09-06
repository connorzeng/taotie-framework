package com.connor.common.tool;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
     * 获取容器中所有的bean
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


    public static void logBeanDefinition(AnnotationConfigApplicationContext applicationContext) {

        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        System.out.println("beanDefinitionCount:" + beanDefinitionCount);
        System.out.println("beanDefinitionNames:" + JSON.toJSONString(beanDefinitionNames));
    }
}

