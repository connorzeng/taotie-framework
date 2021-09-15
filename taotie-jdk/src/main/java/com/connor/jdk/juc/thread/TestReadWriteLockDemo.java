package com.connor.jdk.juc.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLockDemo {


    public static void main(String[] args) {





    }

}

class MyCache{

    private volatile Map<String,String> map = new HashMap<>();

    public void put(String key,String value){
        System.out.println(Thread.currentThread().getName() + " 写入:" + key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName() + " 写入Ok" );
    }
    public String get(String key){
        System.out.println(Thread.currentThread().getName() + " 读取:" + key);
        String s = map.get(key);
        System.out.println(Thread.currentThread().getName() + " 读取Ok" );
        return s;
    }
}
class MyLockCache{

    private volatile Map<String,String> map = new HashMap<>();

    // 读写锁也分为公平锁,非公平锁,用的都是同一个队列.
    //        sync = fair ? new FairSync() : new NonfairSync();
    //        readerLock = new ReadLock(this);
    //        writerLock = new WriteLock(this);
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key,String value){

        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " 写入:" + key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + " 写入Ok" );
        } finally {
            lock.writeLock().unlock();
        }



    }
    public String get(String key){

        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " 读取:" + key);
            String s = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取Ok" );
            return s;
        } finally {
            lock.readLock().unlock();
        }

    }
}
