package com.connor.taotie.tool.delay;

public abstract class AbstrackDelayManager implements DelayManager{


    /**
     * 入队列等待执行
     * @param task
     */
    @Override
    public void delayHandler(Task task) {

        if (task.getState() == 0){

            task.getTaskHandler().handleTask(task);

            if (task.getState() == 1){
                //继续进行delay
                addDelayQueue(task);
            } else if (task.getState() == 2){
                //终止delay,保存数据库
                saveToDb(task);
            }
        }
    }

    protected abstract void saveToDb(Task task);


    protected abstract void addDelayQueue(Task task);

}
