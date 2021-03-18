package com.connor.other.test.adapter.impl;

import com.connor.other.test.adapter.OrderService;
import org.springframework.stereotype.Service;

import org.apache.dubbo.common.URL;

/**
 * protocolParam: mem
 */
@Service("mem")
public class MemOrderService implements OrderService {


    /**
     * methodParam: qryOrder
     */
    @Override
    public void qryOrder(URL url) {
        System.out.println("MemOrderService - qryOrder");
    }

    /**
     * methodParam: qryOrder
     */
    @Override
    public void commitOrder(URL url) {
        System.out.println("MemOrderService - commitOrder");
    }
}
