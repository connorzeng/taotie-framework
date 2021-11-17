package com.connor.taotie.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfig
@SpringBootApplication
@MapperScan("com.connor.taotie.provider.dao.mapper")
public class ProviderApplicationBoot {


    public static void main(String[] args) {
        SpringApplication.run(ProviderApplicationBoot.class, args);
    }
}
