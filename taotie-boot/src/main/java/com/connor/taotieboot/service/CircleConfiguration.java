package com.connor.taotieboot.service;

import com.connor.taotieboot.service.impl.AServiceImpl;
import com.connor.taotieboot.service.impl.BServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 测试循环依赖
 */
@Configuration
public class CircleConfiguration {


    @Bean
    public BService bService(){
        return  new BServiceImpl();
    }

    @Bean
    public AService aService(){
        return new AServiceImpl();
    }

    // 代理类先进行初始化会造成循环依赖.
    // BService-> AService -> BService(提前暴露)
    // BService-> AService
    // BService




}
