package com.connor.jdk;


import org.checkerframework.checker.units.qual.K;

//实现一个hash表，支持insert和get操作，hash冲突使用双向链表处理（自己实现，不要用库），hash函数简单实现
public class TestDemo {


    public static void main(String[] args) {

        User user1 = new User("zhangsan", 1);
        User user2 = new User("zhangsan", 2);
        User user3 = new User("zhangsan", 3);
        User user4 = new User("zhangsan", 3);
        User user = new User("ZENG", 28);


        MyHashMap myHashMap = new MyHashMap(8);
        myHashMap.insert(user1, "zhangsan1");
        myHashMap.insert(user2, "zhangsan2");
        myHashMap.insert(user3, "zhangsan3");
        myHashMap.insert(user3, "zhangsan4");

        myHashMap.insert(user, "ZENG28");
        myHashMap.insert(user, "ZENG40");


        System.out.println(myHashMap.get(user1));
        System.out.println(myHashMap.get(user2));
        System.out.println(myHashMap.get(user3));
        System.out.println(myHashMap.get(user));
    }


}


class MyHashMap {

    //1. 初始容量
    private int capcity = 8;
    private Node[] TABLE = new Node[8];
    //2. 负载因子
    private double loaderFac = 0.75;

    public MyHashMap(int capcity) {
        this.capcity = capcity;
    }

    public void insert(Object key, Object value) {
        //int[] array = new int[3];
        //计算key int
        int hash = key.hashCode();//此处可以去int 高16位做异或
        int slot = hash & (capcity - 1);

        Node curNode = new Node(key, value);
        if (TABLE[slot] == null) {
            curNode.setHeader(curNode);
            curNode.setTail(curNode);
            TABLE[slot] = curNode;
        } else {
            inNodeList(TABLE[slot], curNode);
        }
    }

    private void inNodeList(Node node, Node curNode) {

        //确定是否已经inert过
        Node existedNode = searchValue(node, curNode.getKey());
        if (existedNode != null){
            existedNode.setValue(curNode.value);
            return;
        }

        //新insert key
        Node tail = node.getTail();
        curNode.setPre(tail);
        tail.setNext(curNode);
        node.setTail(curNode);
    }


    public Object get(Object key) {
        int hash = key.hashCode();//此处可以去int 高16位做异或
        int slot = hash & (capcity - 1);

        if (TABLE[slot] == null) {
            return null;
        } else {
            return searchValue(TABLE[slot], key).getValue();
        }
    }

    private Node searchValue(Node node, Object key) {

        Node cur = node;
        while (cur != null) {
            if (cur.getKey().equals(key)) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    class Node {
        private Object key;
        private Object value;
        private Node pre;
        private Node next;
        private Node header;
        private Node tail;

        public Node(Object key, Object value) {
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

        public Node getHeader() {
            return header;
        }

        public void setHeader(Node header) {
            this.header = header;
        }

        public Node getTail() {
            return tail;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

}


class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
