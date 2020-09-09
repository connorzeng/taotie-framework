package com.connor.taotie.ioc.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DefaultPersionFactory implements PersionFactory, InitializingBean, DisposableBean {

    //<context:annotation-config />
    //或者使用AnnotationConfigApplicationContext
    @PostConstruct
    public void initPostConstruct(){
        System.out.println("DefaultPersionFactory-PostConstruct-init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DefaultPersionFactory-afterPropertiesSet-init");
    }

    public void init(){
        System.out.println("DefaultPersionFactory-init");
    }

    @PreDestroy
    public void closePreDestroy() throws Exception {
        System.out.println("DefaultPersionFactory-PreDestroy-close");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DefaultPersionFactory-destroy-close");
    }

    public void close() throws Exception {
        System.out.println("DefaultPersionFactory-close");
    }
}
