package com.connor.taotie.ioc.pojo;

/**
 * 作为persion的属性对象进行注入
 */
public class PersionAddress {

    /**
     * 民族
     */
    private String nation;


    /**
     * 国家
     */
    private String state;

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "PersionAddress{" +
                "nation='" + nation + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
