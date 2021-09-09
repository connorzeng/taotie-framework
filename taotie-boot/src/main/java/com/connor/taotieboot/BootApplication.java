package com.connor.taotieboot;


import com.connor.taotieboot.annotation.EnableClolor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableClolor
//@EnableAsync
//@EnableAspectJAutoProxy
public class BootApplication {


    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
