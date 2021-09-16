package com.connor.jdk.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

public class TestCallableDemo {


    //Callable
    //Runnable, 没有返回值,不会抛出异常.

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyThread callable = new MyThread();
        FutureTask<String> task = new FutureTask<>(callable);

        // 线程启动的方式只有一种.
        new Thread(task).start();
        new Thread(task).start();
        System.out.println(task.get());
        new Thread(task).start();
        System.out.println(task.get());
    }
}


class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("hello-call");
        return "hello";
    }
}