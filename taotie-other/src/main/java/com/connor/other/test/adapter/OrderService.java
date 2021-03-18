package com.connor.other.test.adapter;


import org.apache.dubbo.common.URL;

/**
 * 使用Spring容器来模拟实现dubbo的自适应能力
 */
public interface OrderService {

    /**
     * 查询订单
     */
    void qryOrder(URL url);

    /**
     * 提交订单
     */
    void commitOrder(URL url);
}
