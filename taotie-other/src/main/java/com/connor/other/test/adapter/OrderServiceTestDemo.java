package com.connor.other.test.adapter;

import org.apache.dubbo.common.URL;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTestDemo {

    /**
     * 基于Spring容器模拟实现DUBBO自适应特性
     * @param args
     */
    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.connor.other.test.adapter");
        applicationContext.refresh();

        // 通过新建OrderServiceAdapter来达到通过protocol参数进行service自动选择.
        // 缺点: 对于不同的service需要手动编写对应的adapter代码, 如OrderServiceAdapter
        OrderServiceAdapter orderServiceAdapter = (OrderServiceAdapter)applicationContext.getBean("orderServiceAdapter");
        orderServiceAdapter.qryOrder(new URL("acct","pingan",80));
        orderServiceAdapter.qryOrder(new URL("aum","pingan",80));
        orderServiceAdapter.qryOrder(new URL("mem","pingan",80));
    }
}
