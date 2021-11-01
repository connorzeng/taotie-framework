package com.connor.taotie.tool.service;

import com.connor.taotie.tool.delay.Task;
import com.connor.taotie.tool.delay.TaskHandler;

public class FiveOneOrderTask implements Task {

    @Override
    public int getState() {
        return 0;
    }

    @Override
    public String getTaskName() {
        return null;
    }

    @Override
    public String getTaskId() {
        return null;
    }

    @Override
    public FiveOneOrder getParam() {
        FiveOneOrder fiveOneOrder = new FiveOneOrder();
        fiveOneOrder.setName("zenggang");
        return fiveOneOrder;
    }

    @Override
    public TaskHandler getTaskHandler() {
        return new FiveOneOrderTaskHandler();
    }

    @Override
    public int getDelayLevel() {
        return 0;
    }

    @Override
    public int getDelayTime() {
        return 0;
    }
}
