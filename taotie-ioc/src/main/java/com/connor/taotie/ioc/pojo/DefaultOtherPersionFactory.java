package com.connor.taotie.ioc.pojo;

public class DefaultOtherPersionFactory implements PersionFactory{

    @Override
    public Persion createPersion() {
        Persion persion = new Persion();
        persion.setName("曾罡-DefaultOtherPersionFactory");
        persion.setAge(1);
        return persion;
    }
}
