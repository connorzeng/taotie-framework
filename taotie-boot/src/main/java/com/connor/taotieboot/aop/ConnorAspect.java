package com.connor.taotieboot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ConnorAspect {


    @Pointcut("within(com.connor.taotieboot.controller.*)")
    public void inSvcLayer() {




    }
}
