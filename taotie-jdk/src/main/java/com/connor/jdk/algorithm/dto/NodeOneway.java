package com.connor.jdk.algorithm.dto;

public class NodeOneway {


    private NodeOneway next;

    private String value;


    public NodeOneway(String value) {
        this.value = value;
    }

    public NodeOneway getNext() {
        return next;
    }

    public void setNext(NodeOneway next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public NodeOneway buildNext(NodeOneway nodeOneway) {
        setNext(nodeOneway);
        return nodeOneway;
    }

    public void print() {
        System.out.println(value);
        NodeOneway index = next;
        while (index != null) {
            System.out.println(index.value);
            index = index.next;
        }
    }
}
