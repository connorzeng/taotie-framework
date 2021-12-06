package com.connor.jdk.algorithm;

import org.checkerframework.checker.units.qual.A;

public class RervertListDemo {

    public static void main(String[] args) {
        
        Node a = new Node("1");
        Node b = new Node("2");
        Node c = new Node("3");
        a.setNext(b);
        b.setNext(c);
        print(a);
        System.out.println("after rervet ==================");
        Node revert = revert(a);

        print(revert);
    }



    private static Node revert(Node a) {

        if (a == null || a.getNext() == null){
            return a;
        }

        Node current = a;
        Node next = a.getNext();
        current.setNext(null);

        while (next.getNext() != null){

            Node temp = next.getNext();
            next.setNext(current);

            current = next;
            next = temp;
        }
        next.setNext(current);

        return next;
    }


    private static void print(Node a) {
        Node current = a;
        while (current.getNext()!=null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
        System.out.println(current.getValue());
    }
}

class Node{

    public Node(String value) {
        this.value = value;
    }

    private Node next;
    
    private String value;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
