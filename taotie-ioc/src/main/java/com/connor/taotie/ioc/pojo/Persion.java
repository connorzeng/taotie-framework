package com.connor.taotie.ioc.pojo;

/**
 * javabean三大元数据要素: properties, events, and methods
 *
 *
 */
public class Persion {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    /**
     * 可写入属性
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
