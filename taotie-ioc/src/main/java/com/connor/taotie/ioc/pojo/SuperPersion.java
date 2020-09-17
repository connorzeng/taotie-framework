package com.connor.taotie.ioc.pojo;


import com.connor.taotie.ioc.annotation.Super;

@Super
public class SuperPersion extends Persion{


    private String address;

    private String ability;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "SuperPersion{" +
                "address='" + address + '\'' +
                ", ability='" + ability + '\'' +
                "} " + super.toString();
    }
}
