package com.connor.jdk.juc.collection;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 测试集合类的安全.
 */
public class Test {

    public static void main(String[] args) {


        // 1.并发修改异常 java.util.ConcurrentModificationException ( 使用Collections.synchronizedCollection无法解决 )
        // 2.并发添加会造成数据被覆盖,丢数据.
//        ArrayList<String> list = new ArrayList<>();
//        Collection<String> list = new Vector<>();
//        Collection<String> list = Collections.synchronizedCollection(new ArrayList<>());
        Collection<String> list = new CopyOnWriteArrayList();

        // 进行一个增加
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    list.add(finalI + "" + j + "");
                    //System.out.println(list);
                }
            }, i + "").start();

            new Thread(()->{
                Iterator<String> iterator = list.iterator();
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

        System.out.println(list.size());
    }


}
