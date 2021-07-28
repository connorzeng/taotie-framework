package com.connor.jdk.thread;


/**
 * 测试ThreadLocal
 */
public class ThreadLocalDemo {

    static ThreadLocal<String> SESSION = ThreadLocal.withInitial(() -> "");
    //static ThreadLocal<String> SESSION = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {

            SESSION.set("hello");
            SESSION.set("hellonow");


            System.gc();
            try {
                Thread.sleep(Long.parseLong("2000"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111111111111:" + SESSION.get());

        }).start();


        new Thread(() -> {
            SESSION.set("hello2");
            System.out.println(SESSION.get());

        }).start();


        Thread.sleep(Long.parseLong("200"));
        SESSION.get();

    }

}
