package com.connor.jdk.juc.collection;

import java.util.concurrent.SynchronousQueue;

public class TestSynchronousQueueDemo {

    public static void main(String[] args) {

        //感觉ArrayBlockingQueue就像一个隧道，而SynchronousQueue就像一个门框（门框上不可以站人），进出队列就是穿门而过。
        //进出队列就是穿门而过。
        //jdk提供的newCachedThreadPool线程池就是用了SynchronousQueue做任务队列，而他的核心线程数为0，最大线程数为无限大。


        SynchronousQueue queue = new SynchronousQueue();





    }


}
