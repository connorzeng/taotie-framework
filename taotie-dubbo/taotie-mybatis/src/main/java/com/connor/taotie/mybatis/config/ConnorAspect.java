package com.connor.taotie.mybatis.config;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConnorAspect {

    //定义切面
    @Pointcut("execution(* com.connor.taotie.mybatis.controller(..))") // expression
    private void controllerService() {}  // signature


    @Before("controllerService()")
    public void doBeforeTask(){
        System.out.println("before");
    }

    @After("controllerService()")
    public void doAfterTask(){
        System.out.println("After");
    }

    @AfterReturning(pointcut="controllerService()", returning="retVal")
    public void doAfterReturnningTask(Object retVal) {
        System.out.println("AfterReturning");
    }

    @AfterThrowing(pointcut="controllerService()", throwing="ex")
    public void doAfterThrowingTask(Exception ex) {
        System.out.println("AfterThrowing");

    }

    @Around("controllerService()")
    public void doAroundTask(){
        System.out.println("Around");
    }
}
