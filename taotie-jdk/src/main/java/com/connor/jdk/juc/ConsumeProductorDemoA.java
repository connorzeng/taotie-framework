package com.connor.jdk.juc;

public class ConsumeProductorDemoA {

    public static void main(String[] args) {

        Data data = new Data();

        new Thread(()->{
            for (int i = 0;i<20;i++){
                data.increment();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0;i<20;i++){
                data.decrement();
            }
        },"B").start();


        new Thread(()->{
            for (int i = 0;i<20;i++){
                data.increment();
            }
        },"c").start();

        new Thread(()->{
            for (int i = 0;i<20;i++){
                data.decrement();
            }
        },"d").start();
    }


}

class Data {

    private volatile int i = 0;


    // 等待唤醒必须要加synchronized
    public synchronized void increment() {

        //if (i > 0){ //使用if会造成虚假唤醒
        while (i > 0){
            try {
                wait();//必须获取
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i++;
        System.out.println(Thread.currentThread().getName() + "->" + i);
        notifyAll();
    }

    // 等待唤醒必须要加synchronized
    public synchronized void decrement()  {
        //if (i == 0){
        while (i == 0){
            try {
                wait();//必须获取
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i--;
        System.out.println(Thread.currentThread().getName() + "->" + i);
        notifyAll();
    }

}


