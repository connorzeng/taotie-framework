package com.connor.taotie.tool.delay;

public interface Task {

    /**
     * 0: 马上执行
     * 1: 等待状态
     * 2: 终止执行,入库持久化.
     * 3. 终止执行,不做操作.
     * @return
     */
    int getState();

    /**
     * 获取TaskName
     * @return
     */
    String getTaskName();

    /**
     * 获取TaskId
     * @return
     */
    String getTaskId();

    /**
     * 获取任务参数
     * @return
     */
    <T> T getParam();


    /**
     * 获取任务handler
     * @return
     */
    TaskHandler getTaskHandler();


    /**
     * 1,2, 3, 4, 5, 6, 7, 8, 9,10
     * @return
     */
    int getDelayLevel();

    /**
     * 1,2, 3, 4, 5, 6, 7, 8, 9,10--delayLevel
     * 1,2, 2, 2, 5, 5, 5,10,10,10--delayTime
     * @return
     */
    int getDelayTime();

}
