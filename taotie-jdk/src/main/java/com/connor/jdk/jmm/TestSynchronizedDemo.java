package com.connor.jdk.jmm;

import java.util.concurrent.TimeUnit;

public class TestSynchronizedDemo {

    public static void main(String[] args) {

        Robet robet = new Robet();

        new Thread(robet::cleanHome).start();


        new Thread(robet::cookFood).start();
    }
}

/**
 * 卸载method上面是锁住this对象
 */
class Robet{


    public synchronized void  cleanHome()  {
        System.out.println("我要打扫了了");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void  cookFood() {
        System.out.println("我要煮饭了");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
