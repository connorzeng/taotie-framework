package com.connor.taotie.ioc.pojo;

import com.connor.common.constants.City;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * javabean三大元数据要素: properties, events, and methods
 */
public class Persion {


    /**
     * 这个是用来测试Autowired的顺序在setter之前
     */
    @Autowired(required = false)
    private PersionAddress persionAddress;

    private String name;
    private Integer age;
    private City city;

    private long id;

    public Persion(String name, Integer age) {
        this.name = name;
        this.age = age;
        //System.out.println("我是Persion构造器");
    }

    public Persion() {
//        System.out.println("我是Persion构造器");
//        if (persionAddress != null) {
//            System.out.println("persionAddress inited " + persionAddress.toString());
//        } else {
//            System.out.println("persionAddress is null");
//        }
    }

    /**
     * 必须是static public
     *
     * @return
     */
    public static Persion createPersion() {
        Persion persion = new Persion();
        persion.setName("staticMethod曾罡");
        persion.setAge(1);
        return persion;
    }

    public String getName() {
        return name;
    }

    /**
     * 可写入属性
     *
     * @param name
     */
    public void setName(String name) {
//        System.out.println("persion.setName()");
//        if (persionAddress != null) {
//            System.out.println("persionAddress inited " + persionAddress.toString());
//        } else {
//            System.out.println("persionAddress is null");
//        }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "persionAddress=" + persionAddress +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", id=" + id +
                '}';
    }

    public void destory() {
        System.out.println(this.name + this.id + ":销毁中");
    }
}
