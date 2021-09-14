package com.connor.jdk.juc.collection;


import org.apache.dubbo.common.utils.ConcurrentHashSet;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * 测试集合类的安全.
 */
public class TesHashSetDemo {

    public static void main(String[] args) {

//        Set<String> set = new HashSet<>();


        Set<String> set = new CopyOnWriteArraySet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());

        // 进行一个增加
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    set.add(finalI + "" + j + "");
                    //System.out.println(list);
                }
            }, i + "").start();

            new Thread(()->{
                Iterator<String> iterator = set.iterator();
                while(iterator.hasNext()){
                    String next = iterator.next();
                }
            }).start();
        }


        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(set.size());

    }


}
