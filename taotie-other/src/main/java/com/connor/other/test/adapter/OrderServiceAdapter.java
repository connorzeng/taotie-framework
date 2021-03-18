package com.connor.other.test.adapter;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import org.apache.dubbo.common.URL;

@Service
public class OrderServiceAdapter implements OrderService, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void qryOrder(URL url) {

        String protocol = url.getProtocol();
        OrderService orderService = (OrderService)applicationContext.getBean(protocol);
        orderService.qryOrder(url);
    }

    @Override
    public void commitOrder(URL url) {
        String protocol = url.getProtocol();
        OrderService orderService = (OrderService)applicationContext.getBean(protocol);
        orderService.commitOrder(url);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
