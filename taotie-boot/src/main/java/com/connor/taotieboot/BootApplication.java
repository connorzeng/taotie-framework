package com.connor.taotieboot;


import com.connor.taotieboot.annotation.EnableClolor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@ServletComponentScan
@SpringBootApplication
@EnableClolor
@EnableAsync// -- 需要引入org.aspectj#aspectjweaver才能自动依赖,如果没有就需要写EnableAsync
@EnableAspectJAutoProxy(exposeProxy=true) //开AOP (AopContext.currentProxy) 强制使用本地代理类
//@EnableWebMvc
@ImportResource("classpath:/springBean.xml")///demo/hello
public class BootApplication {


    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
