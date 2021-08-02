package com.connor.taotieboot.process;

import com.connor.taotieboot.controller.HelloWorldController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class ControllerBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof HelloWorldController){

            System.out.println("HelloWorldController - postProcessBeforeInitialization");

        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof HelloWorldController){

            System.out.println("HelloWorldController - postProcessAfterInitialization");

        }
        return bean;
    }
}
