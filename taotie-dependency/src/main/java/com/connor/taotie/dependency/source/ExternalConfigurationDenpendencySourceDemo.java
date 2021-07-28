package com.connor.taotie.dependency.source;

import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;

/**
 * 外部依赖的注入
 */
//@Configuration
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

    @Bean
    public Persion persion(){
        return new Persion();
    }


    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Test test(){
        return new Test();
    }


    class Test implements ApplicationListener<ContextRefreshedEvent>{

        public Test(){
            System.out.println("");
        }

        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            ApplicationContext source = (ApplicationContext) event.getSource();
            System.out.println(source.getApplicationName() + " refreshed");
        }
    }


}
