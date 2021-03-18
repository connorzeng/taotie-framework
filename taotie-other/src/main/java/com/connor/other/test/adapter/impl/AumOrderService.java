package com.connor.other.test.adapter.impl;

import com.connor.other.test.adapter.OrderService;
import org.springframework.stereotype.Service;

import org.apache.dubbo.common.URL;

/**
 * protocolParam: aum
 */
@Service("aum")
public class AumOrderService implements OrderService {


    @Override
    public void qryOrder(URL url) {
        System.out.println("AumOrderService - qryOrder");
    }

    @Override
    public void commitOrder(URL url) {
        System.out.println("AumOrderService - commitOrder");
    }
}
