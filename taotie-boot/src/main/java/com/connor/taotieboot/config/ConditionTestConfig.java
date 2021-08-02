package com.connor.taotieboot.config;


import com.connor.taotieboot.dto.Red;
import com.connor.taotieboot.dto.Yellow;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Red.class)
@ConditionalOnBean(Red.class)
public class ConditionTestConfig {


    @Bean
    public String hello() {
        return "hello";
    }


}
