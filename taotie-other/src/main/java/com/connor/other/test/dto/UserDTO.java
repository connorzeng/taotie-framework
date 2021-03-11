package com.connor.other.test.dto;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserDTO {

    private String name;

    private String age;

    private List<String> arrays;

    private Map<String,String> params = new ConcurrentHashMap<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public List<String> getArrays() {
        return arrays;
    }

    public void setArrays(List<String> arrays) {
        this.arrays = arrays;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", params=" + params +
                '}';
    }
}
