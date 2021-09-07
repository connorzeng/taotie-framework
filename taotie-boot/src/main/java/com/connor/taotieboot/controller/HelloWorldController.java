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
import java.util.ArrayList;
import java.util.List;

@RestController
@PropertySource("classpath:user.yml")
public class HelloWorldController implements ApplicationContextAware {

    @PostConstruct
    private void init(){
        System.out.println("HelloWorldController - init");
    }
    @Autowired
    private ApplicationContext context;

    // 注入yml
    @Value("${ymalName}")
    private String coutry;

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
