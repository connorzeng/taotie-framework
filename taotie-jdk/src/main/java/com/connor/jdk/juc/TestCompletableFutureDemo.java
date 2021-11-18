package com.connor.jdk.juc;


import java.util.concurrent.*;

public class TestCompletableFutureDemo {

    public static void main(String[] args) {


        //1. 指定线程.
        // 生产必须要要使用参数进行构建.
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(200),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        //2. 初始化
        CompletableFuture<String> cf1  = CompletableFuture.supplyAsync(()->{
            return "";
        },threadPoolExecutor);

        CompletableFuture<String> cf2  = cf1.whenComplete((s,e)->{

            return s + "_final";
        });

    }

}
