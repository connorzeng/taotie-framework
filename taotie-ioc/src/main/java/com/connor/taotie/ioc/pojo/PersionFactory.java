package com.connor.taotie.ioc.pojo;

public interface PersionFactory {



    default Persion createPersion() {
        return new Persion("PersionFactory",1);
    }


}
