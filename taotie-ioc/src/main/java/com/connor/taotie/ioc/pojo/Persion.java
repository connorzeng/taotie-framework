package com.connor.taotie.ioc.pojo;

import com.connor.common.constants.City;

/**
 * javabean三大元数据要素: properties, events, and methods
 *
 *
 */
public class Persion {


    public Persion(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Persion() {

    }

    private String name;

    private Integer age;

    private City city;

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city=" + city +
                '}';
    }

    /**
     * 必须是static public
     * @return
     */
    public static Persion createPersion(){
        Persion persion = new Persion();
        persion.setName("staticMethod曾罡");
        persion.setAge(1);
        return persion;
    }


}
