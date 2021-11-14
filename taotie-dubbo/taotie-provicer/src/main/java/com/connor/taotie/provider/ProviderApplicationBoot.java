package com.connor.taotie.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfig
@SpringBootApplication
public class ProviderApplicationBoot {


    public static void main(String[] args) {
        SpringApplication.run(ProviderApplicationBoot.class, args);
    }

}
