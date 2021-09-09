package com.connor.taotieboot.service.impl;

import com.connor.taotieboot.service.AService;
import com.connor.taotieboot.service.BService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * 在JDK代理的时候,如果impl是final,不会影响动态代理
 */
@Service
public class BServiceImpl implements BService {

    @Autowired
    //@Lazy
    private AService aService;

    //@Async
    @Override
    public void sayBHello() {

        System.out.println("Bhello");
        sayHelloPrivate();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    //private方法不会造成启动错误,但是异步会不生效
    //public方法不会造成启动错误,但是异步会不生效
    //@Async
    //只有public能被对象进行调用
    public void sayHelloPrivate(){
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sayHelloPrivate");
    }
}
