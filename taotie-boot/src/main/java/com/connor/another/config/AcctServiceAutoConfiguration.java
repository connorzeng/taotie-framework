package com.connor.another.config;


import com.connor.taotieboot.dto.Red;
import com.connor.taotieboot.service.AccountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcctServiceAutoConfiguration {


    @Bean
    @ConditionalOnClass(Red.class)
    public AccountService accountService(){

        return new AccountService();
    }

}
