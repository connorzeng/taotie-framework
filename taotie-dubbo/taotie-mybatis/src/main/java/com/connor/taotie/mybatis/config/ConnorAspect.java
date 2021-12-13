package com.connor.taotie.mybatis.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class ConnorAspect {

    //定义切面
    @Pointcut("execution(* com.connor.taotie.mybatis.service..*.*(..))") // expression
//    @Pointcut("execution(* com.connor.taotie.mybatis.mappper..*.*(..))") // expression
    private void controllerService() {
    }  // signature

//JoinPoint;
//ProceedingJoinPoint;

    /**
     * ProceedingJoinPoint
     * Caused by: java.lang.IllegalArgumentException: ProceedingJoinPoint is only supported for around advice
     * //这里反不反会都
     *
     * @param joinPoint
     */
    @Before("controllerService()")
    public Object doBeforeTask(JoinPoint joinPoint) {
        System.out.println("before");
        return "hello";
    }

    @After("controllerService()")
    public void doAfterTask() {
        System.out.println("After");
    }

    @AfterReturning(pointcut = "controllerService()", returning = "retVal")
    public void doAfterReturnningTask(Object retVal) {
        System.out.println("AfterReturning");
    }

    @AfterThrowing(pointcut = "controllerService()", throwing = "ex")
    public void doAfterThrowingTask(Exception ex) {
        System.out.println("AfterThrowing");

    }

    /**
     * ProceedingJoinPoint is only supported for around advice
     */
    @Around("controllerService()")
    public Object doAroundTask(ProceedingJoinPoint joinPointp) throws Throwable {

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Around");
        return joinPointp.proceed();
    }
}
