package com.connor.taotie.bok.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TimeUsed {

    /**
     * 打印的耗时默认为毫秒
     * @return
     */
    TimeUnit timeValue() default TimeUnit.MILLISECONDS;

}
