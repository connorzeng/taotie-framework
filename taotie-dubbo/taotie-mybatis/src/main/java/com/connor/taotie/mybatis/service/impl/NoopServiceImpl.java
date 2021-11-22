package com.connor.taotie.mybatis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NoopServiceImpl {


    //不生效
    public final void finalTest(){
        log.info("finalTest");
    }

    //不生效,不能包外调用.
    private void privateTest(){
        log.info("privateTest");
    }


    //不生效,不能包外调用.
    protected void protectTest(){
        log.info("protectTest");
    }

    //生效
    public void publicTestNomal(){
        log.info("publicTestNomal");
    }

    //自己调用自己-->不会生效
    public void publicTestSelf(){

        //自己调用自己会不会进入AOP?
        publicTestNomal();

        // private,protect只能做自调用
        privateTest();
        protectTest();
        log.info("publicTestSelf");
    }

    //自己调用自己-->不会生效
    public void publicTestSelfCurrentProxy(){

        //// 通过ThreadLocal来实现的
        //private static final ThreadLocal<Object> currentProxy = new NamedThreadLocal<Object>("Current AOP proxy");

        //请避免自调用
        //请避免自调用
        //请避免自调用
        //获取代理类
        NoopServiceImpl currentProxy = (NoopServiceImpl)AopContext.currentProxy();

        //自己调用自己会不会进入AOP?
        currentProxy.publicTestNomal();

        // private,protect只能做自调用
        currentProxy.privateTest();
        currentProxy.protectTest();
        log.info("publicTestSelfCurrentProxy");
    }

}
