package com.connor.taotieboot.controller;

import com.connor.taotieboot.service.AService;
import com.connor.taotieboot.service.BService;
import com.connor.taotieboot.service.impl.BServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@PropertySource({"classpath:application.yml","classpath:user.yml"})
public class HelloWorldController implements ApplicationContextAware {

    @PostConstruct
    private void init(){
        System.out.println("HelloWorldController - init");
    }
    @Autowired
    private ApplicationContext context;


//Caused by: org.springframework.beans.factory.BeanCurrentlyInCreationException:
// Error creating bean with name 'BServiceImpl': Bean with name 'BServiceImpl' has been injected into other beans
// [AServiceImpl] in its raw version as part of a circular reference, but has eventually been wrapped.
// This means that said other beans do not use the final version of the bean. This is often the result of over-eager type
// matching - consider using 'getBeanNamesForType' with the 'allowEagerInit' flag turned off, for example.
// at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:631) ~[spring-beans-5.3.8.jar:5.3.8]
//    @Autowired
//    @Lazy
//    //private BServiceImpl bService;//在代理类的情况下回抛出错误
//    private BService bService;

//    @Autowired
//    @Lazy
//    //private BServiceImpl bService;//在代理类的情况下回抛出错误
//    private BServiceImpl bServiceImpl;


    // helloWorldController --> aService --> bService ---->(aService)
    @Autowired
    private AService aService;

    // 注入yml
    @Value("${ymalName}")
    private String coutry;

    @RequestMapping("/testCicle")
    public String testCicle() {

//        bServiceImpl.sayBHello();
//        bServiceImpl.sayHelloPrivate();

//        aService.sayAHello();

        return "Hello World";
    }

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/string")
    public String stringTest() {
        List<String> a = new ArrayList<>();
        int i = 0;
        while(true){
            a.add(String.valueOf(i++).intern());
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("HelloWorldController - aware");
    }
}
