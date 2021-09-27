package com.connor.jdk.funtion;


import java.util.ArrayList;
import java.util.List;

public class StreamTestDemo {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(34, "connor"));
        students.add(new Student(28, "huaxiang"));
        students.add(new Student(30, "xiaozong"));
        students.add(new Student(20, "xiaoxianrou"));

        students.stream().filter((s) -> {
            if (s.getAge() >= 30) {
                return true;
            }
            return false;
        }).filter((s) -> {
            if (s.getName().startsWith("x")) {
                return true;
            }
            return false;
        }).map((s)->{
            if (s.getName().equals("xiaozong")){
                s.setOk(true);
            }
            return s;
        }).forEach((s) -> {
            System.out.println(s);
        });
    }

}

class Student {

    private int age;
    private String name;
    private boolean isOk;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", isOk=" + isOk +
                '}';
    }
}