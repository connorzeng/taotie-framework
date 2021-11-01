package com.connor.taotie.tool.service;

import com.connor.taotie.tool.delay.Task;
import com.connor.taotie.tool.delay.TaskHandler;

public class FiveOneOrderTaskHandler implements TaskHandler<FiveOneOrder> {


    private OrderService orderService = new OrderSericeImpl();


    @Override
    public FiveOneOrder handleTask(Task task) {



        orderService.handle(task.getParam());



        return null;
    }
}
