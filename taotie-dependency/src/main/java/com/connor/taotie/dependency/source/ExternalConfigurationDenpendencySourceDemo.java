package com.connor.taotie.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * 外部依赖的注入
 */
@Configuration
@PropertySource(value = "classpath:/default.properties",encoding = "UTF-8")
public class ExternalConfigurationDenpendencySourceDemo {

    //1. 通过@PropertySource直接注入properties文件, 中文需要配置编码格式
    //2. 直接@Value读取
    //3. ${connor.name:大缸子老师备用}获取默认值

    @Value("${connor.name:大缸子老师备用}")
    private String name;

    @Value("${connor.namebak:大缸子老师备用}")
    private String namebak;

    @Value("${connor.age}")
    private String age;

    @Value("${connor.resource:classpach:/default.properties}")
    private Resource resource;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ExternalConfigurationDenpendencySourceDemo.class);



        // 启动容器
        applicationContext.refresh();

        // 获取Bean
        ExternalConfigurationDenpendencySourceDemo bean = applicationContext.getBean(ExternalConfigurationDenpendencySourceDemo.class);
        System.out.println(bean.age);
        System.out.println(bean.name);
        System.out.println(bean.namebak);
        System.out.println(bean.resource);

        applicationContext.close();
    }

}
