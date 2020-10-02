package com.connor.taotie.dependency.annotation;


import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 *
 * 自定义的注入标签
 * (会有自定义的xml主表标签,这里还没有涉及)
 *  继承@Autowired
 *  参照@Autowired来进行
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Autowired
public @interface ConnorAutowired {


}
