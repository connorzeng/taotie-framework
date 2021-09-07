package com.connor.jdk.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {


    public static void main(String[] args) {

        LRUCache<String,String> lruCache = new LRUCache<>(3);
        lruCache.put("key1","value1");
        lruCache.put("key2","value2");
        lruCache.put("key3","value3");
        lruCache.printMap();
        lruCache.put("key4","value4");
        lruCache.printMap();
        lruCache.put("key5","value5");
        lruCache.printMap();
        lruCache.put("key6","value6");
        lruCache.printMap();
        lruCache.put("key7","value7");
        lruCache.printMap();
        lruCache.put("key8","value8");
        lruCache.printMap();
    }


    private int capicity = 16;
    // 这里非常重要.
    private Map<K,Node> map;
    private Node header;
    private Node tail;


    public void printMap(){
        System.out.println(JSON.toJSONString(map));
    }


    public Object put(K key,V value){
        Node node = map.get(key);
        if (node == null){
            if (map.size() == capicity){
                removeTail();
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            addHeader(newNode);
            return value;
        } else {
            if (node.value.equals(value)){
                addHeader(node);
                return value;
            } else {
                node.setValue(value);
                addHeader(node);
                map.put(key,node);
                return value;
            }
        }
    }

    public Object get(K k){
        Node node = map.get(k);
        if (node == null){
            return null;
        }

        addHeader(node);

        return node.getValue();
    }



    public LRUCache(){
        this.capicity = 16;
        map = new HashMap<>();
    }
    public LRUCache(int capicity){
        this.capicity = capicity;
        map = new HashMap<>();
    }

    // 删除队尾元素
    public void removeTail(){

        if (tail == null){
            return;
        }

        map.remove(tail.key);


        Node tailPre = tail.pre;
        tail = tailPre;
        tail.next = null;
    }

    // 添加到队首
    public void addHeader(Node node){
        if (header == null){
            // 首次加入没有尾巴
            header = node;
        } else {
            Node next = header;
            header = node;
            header.next = next;
            next.pre = header;
            if (tail == null){
                tail = next;
            }
        }
    }

    // 移动到队首
    public void moveToHeader(Node node){

        if (node == header){
            return;
        }
        if (node == tail){
            // 存临时值
            Node headNext = header;
            Node newTail = tail.pre;

            // 赋值
            header = tail;
            header.next = headNext;
            tail = newTail;
            return;
        }

        // 存临时值
        Node currentPre = node.pre;
        Node currentNext = node.next;
        Node headNext = header;

        // 赋值
        header = node;
        header.next = headNext;
        currentPre.next = currentNext;
    }



    class Node<K,V>{
        private Node pre;
        private Node next;

        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
