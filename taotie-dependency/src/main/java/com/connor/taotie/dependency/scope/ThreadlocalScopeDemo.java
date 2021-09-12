package com.connor.taotie.dependency.scope;


import ch.qos.logback.core.util.TimeUtil;
import com.connor.taotie.ioc.pojo.Persion;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;

import static com.connor.taotie.dependency.scope.ThreadlocalScope.SCOPE_NAME;

/**
 * 自定义scope
 */
public class ThreadlocalScopeDemo {

    // 1.新建一个ThreadlocalScope继承Scope
    // 在新建类里面维护一个NamedThreadLocal-->ThreadLocal
    // bean最终还是要在beanFactory里面获取
    // 2.容器启动的时候需要注册这个Scope
    // BeanFactoryPostProcessor
    // 3.多线程执行获取bean


    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ThreadlocalScopeDemo.class);
        // 这里需要注册SCOPE
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerScope(SCOPE_NAME, new ThreadlocalScope());
        });

        // 刷新容器
        applicationContext.refresh();

        for (int i = 1000; i > 0; i--) {

            Thread thread = new Thread(() -> {

                Persion threadPersion = (Persion) applicationContext.getBean("threadPersion");
                System.out.println(threadPersion);
                System.out.println(Thread.currentThread().getId() == threadPersion.getId());
            });

            thread.start();
        }


        TimeUnit.SECONDS.sleep(1);//使用工具类来进行sleep

        applicationContext.close();
    }

    @Bean
    public Persion threadPersion1() {
        Persion persion = new Persion("刚子老师棒耶", 1);
        persion.setId(Thread.currentThread().getId());

        return persion;
    }

    @Bean
    @Scope(value = ThreadlocalScope.SCOPE_NAME)
    public Persion threadPersion() {
        Persion persion = new Persion("刚子老师棒耶", 1);
        persion.setId(Thread.currentThread().getId());

        return persion;
    }

}
