package com.connor.taotie.ioc.pojo;


import com.connor.taotie.ioc.annotation.Super;

@Super
public class SuperPersion extends Persion{


    private String address;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperPersion{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
