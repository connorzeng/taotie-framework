package com.connor.taotieboot.application;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class PropertiesBeanFactoryPostProcessor extends PropertySourcesPlaceholderConfigurer {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        Properties properties = new Properties();
        properties.put("connorNanme.hello","超级无敌大缸子");
        setProperties(properties);
        super.postProcessBeanFactory(beanFactory);
    }

}
