package com.connor.jdk.juc.collection;

import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class TestSynchronousQueueDemo {

    public static void main(String[] args) {

        //感觉ArrayBlockingQueue就像一个隧道，而SynchronousQueue就像一个门框（门框上不可以站人），进出队列就是穿门而过。
        //进出队列就是穿门而过。
        //jdk提供的newCachedThreadPool线程池就是用了SynchronousQueue做任务队列，而他的核心线程数为0，最大线程数为无限大。


        SynchronousQueue queue = new SynchronousQueue();



        // 生产者
        for (int i=0;i<10;i++){
            new Thread(()->{
                try {
                    System.out.println("生产put");
                    queue.put("1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }


        // 生产者
        for (int i=0;i<1;i++){

            int finalI = i;
            new Thread(()->{
                try {
                    for (int j=0;j<10;j++){
                        System.out.println("生产take");
                        queue.take();
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }


}
