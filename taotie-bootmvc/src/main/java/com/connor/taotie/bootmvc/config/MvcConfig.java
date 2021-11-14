package com.connor.taotie.bootmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        
    }

    // 添加静态文件映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }


    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加TestHandlerInterceptor order-0
        registry.addInterceptor(new TestHandlerInterceptor()).addPathPatterns("/**").order(0);

        //添加TestHandlerInterceptorTwo order-1
        registry.addInterceptor(new TestHandlerInterceptorTwo()).addPathPatterns("/**").order(1);
    }
}
