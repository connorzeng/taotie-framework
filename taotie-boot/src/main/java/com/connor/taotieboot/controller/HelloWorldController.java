package com.connor.taotieboot.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@PropertySource("classpath:user.yml")
public class HelloWorldController implements ApplicationContextAware {

    @PostConstruct
    private void init(){
        System.out.println("HelloWorldController - init");
    }
    @Autowired
    private ApplicationContext context;

    // 注入yml弟弟
    @Value("${ymalName}")
    private String coutry;

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("HelloWorldController - aware");
    }
}
