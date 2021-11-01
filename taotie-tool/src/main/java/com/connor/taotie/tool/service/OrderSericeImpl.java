package com.connor.taotie.tool.service;

public class OrderSericeImpl implements OrderService {


    @Override
    public void handle(FiveOneOrder order) {

        System.out.println(order.toString());
        System.out.println("OrderSericeImpl do handle");
    }
}
