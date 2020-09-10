package com.connor.taotie.dependency.lookup;

import com.connor.taotie.ioc.pojo.Persion;
import com.connor.taotie.ioc.pojo.SuperPersion;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类型安全的spring lookup
 */
public class TypeSafeLookupDemo {


    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();


        // 非安全查找
        printStack("getBean", () -> applicationContext.getBean("persion1"));
        printStack("getBeanProvider.getObject", () -> applicationContext.getBeanProvider(SuperPersion.class).getObject());


        // 安全查找 推荐用这个来进行查找
        printStack("getBeanProvider.getIfAvailable", () -> applicationContext.getBeanProvider(Persion.class).getIfAvailable(SuperPersion::createPersion));


        // ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        // beansOfType
        printStack("getBeanProvider.getIfAvailable", () -> applicationContext.getBeansOfType(SuperPersion.class).forEach((k, v) -> {
            System.out.println("getBeanProvider.getIfAvailable");
            System.out.println(k);
        }));


        // ObjectProvider
        printStack("getBeanProvider.getIfAvailable", () -> applicationContext.getBeanProvider(SuperPersion.class).stream().forEach(System.out::println));


        //Map a = null 在解析时会报NPE, a is empty不会进入解析
        /*Map a = new HashMap();
        a.forEach((k,v)->{
            System.out.println("helllo");
            System.out.println(k);
        });*/


        applicationContext.close();
    }


    private static void printStack(String source, Runnable runnable) {

        try {
            runnable.run();
        } catch (Exception e) {
            System.out.println(source + "===============");
            e.printStackTrace();
        }
    }
}
