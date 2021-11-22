package com.connor.taotie.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.connor.taotie.mybatis.mappper")
//才能使用(NoopServiceImpl)AopContext.currentProxy()进行自调用
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableAsync
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
