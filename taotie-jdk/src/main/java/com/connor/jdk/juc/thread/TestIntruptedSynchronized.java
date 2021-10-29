package com.connor.jdk.juc.thread;

public class TestIntruptedSynchronized {


    public static void main(String[] args) {

        Cooker cooker = new Cooker();

        Thread t = new Thread(()->{
            cooker.makeFood();
        });
        t.start();


        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(()->{
            cooker.makeFood();
        });
        t2.start();

        t2.interrupt();
        System.out.println(t2.isAlive());
        //t.interrupt();
        System.out.println(t.isAlive());
    }
}

class Cooker{

    public synchronized void makeFood(){
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "我要保存现场,停止了");
            e.printStackTrace();
        }
    }
}

