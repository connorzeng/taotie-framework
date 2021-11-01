package com.connor.taotie.tool.delay;

public interface TaskHandler<T> {


    T handleTask(Task task);

}
