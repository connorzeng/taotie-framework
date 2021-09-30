package com.connor.jdk.annotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotionInherited {


    //void get();
    // anntation里面默认定义的属性. get这个方法名就是属性名称.
    // 所有建议使用名词来定义如age()
    int get() default 1;
    int age() default 1;

}
