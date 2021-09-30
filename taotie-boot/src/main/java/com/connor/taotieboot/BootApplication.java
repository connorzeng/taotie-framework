package com.connor.taotieboot;


import com.connor.taotieboot.annotation.EnableClolor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableClolor
//@EnableAsync -- 需要引入org.aspectj#aspectjweaver才能自动依赖,所有需要写EnableAsync
//@EnableAspectJAutoProxy
public class BootApplication {


    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
