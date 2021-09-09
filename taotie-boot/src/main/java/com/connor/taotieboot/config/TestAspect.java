package com.connor.taotieboot.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    //@Before("execution(public * com.connor.taotieboot.service.BService.sayBHello(..))")
    //@Before("execution(public * com.connor.taotieboot.service.impl.BServiceImpl.*(..))")
    @Before("execution(public * com.connor.taotieboot.service.impl.BServiceImpl.sayHelloPrivate(..))")
    public void check() {
        System.out.println("point check");
    }
}
