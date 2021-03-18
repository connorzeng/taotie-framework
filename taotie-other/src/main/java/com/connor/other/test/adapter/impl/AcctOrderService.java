package com.connor.other.test.adapter.impl;

import com.connor.other.test.adapter.OrderService;
import org.springframework.stereotype.Service;

import org.apache.dubbo.common.URL;

/**
 * protocolParam: acct
 */
@Service("acct")
public class AcctOrderService implements OrderService {


    @Override
    public void qryOrder(URL url) {
        System.out.println("AcctOrderService - qryOrder");
    }


    @Override
    public void commitOrder(URL url) {
        System.out.println("AcctOrderService - commitOrder");
    }
}
