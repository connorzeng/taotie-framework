package com.connor.taotie.tool;

import com.connor.taotie.tool.service.FiveOneOrderTask;

public class App {

    public static void main(String[] args) {

        FiveOneOrderTask task = new FiveOneOrderTask();
        task.getTaskHandler().handleTask(task);

    }
}
