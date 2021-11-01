package com.connor.taotie.tool.service;

public class FiveOneOrder {

    private String OrderNo;
    private String name;
    private String age;
    private String luckMoney;
    private String sumMoney;
    //0:入库初始化
    //1:订单已提交,结果未知
    //2:订单已提交,订单成功
    //3:订单已提交,失败
    private int orderState;

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

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

    public String getLuckMoney() {
        return luckMoney;
    }

    public void setLuckMoney(String luckMoney) {
        this.luckMoney = luckMoney;
    }

    public String getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(String sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    @Override
    public String toString() {
        return "FiveOneOrder{" +
                "OrderNo='" + OrderNo + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", luckMoney='" + luckMoney + '\'' +
                ", sumMoney='" + sumMoney + '\'' +
                ", orderState=" + orderState +
                '}';
    }
}
