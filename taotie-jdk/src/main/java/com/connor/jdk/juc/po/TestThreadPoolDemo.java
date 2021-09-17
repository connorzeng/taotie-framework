package com.connor.jdk.juc.po;

import java.util.concurrent.*;

public class TestThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //构建函数, 基于工具类进行构建

        //1.无界线程池,核心线程数0,最大线程数Integer.MAX_VALUE
        //基于SynchronousQueue,无界的线程池, 来一个就会创建一个线程.
        //不建议生产使用
        //ExecutorService noLimitTp = Executors.newCachedThreadPool();

        //2.single线程池,核心线程数1,最大线程数1. 阻塞队列最大值Integer.MAX_VALUE
        //不建议生产使用
        //ExecutorService noLimitTp = Executors.newSingleThreadExecutor();

        //3.固定线程池,核心线程数4,最大线程数4. 阻塞队列最大值Integer.MAX_VALUE
        //不建议生产使用
        //ExecutorService noLimitTp = Executors.newFixedThreadPool(4);

        //ExecutorService noLimitTp = Executors.newScheduledThreadPool(4);


        //
        // 无参私有构造函数.
        //ThreadGroup tg = new ThreadGroup();
        ThreadGroup tg =  new ThreadGroup(Thread.currentThread().getThreadGroup(),"ibank-test");

        tg.activeCount();
        tg.setMaxPriority(Thread.MAX_PRIORITY);
        //tg.destroy();

        Thread a = new Thread();


        Executors.defaultThreadFactory();
        // 生产必须要要使用参数进行构建.
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(200),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(()->{
            System.out.println("hello");
        });
        threadPoolExecutor.execute(()->{
            int i = 1/0;
        });
        threadPoolExecutor.prestartAllCoreThreads();
        threadPoolExecutor.prestartCoreThread();
        Future<?> submit = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                int i = 1/0;
            }
        });

        System.out.println(submit.get());


        System.out.println("hello");

    }
}
