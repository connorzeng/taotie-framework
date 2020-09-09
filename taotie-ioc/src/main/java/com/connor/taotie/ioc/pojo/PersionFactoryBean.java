package com.connor.taotie.ioc.pojo;

import org.springframework.beans.factory.FactoryBean;

public class PersionFactoryBean implements FactoryBean<Persion> {


    @Override
    public Persion getObject() throws Exception {
        Persion persion = new Persion();
        persion.setName("曾罡-FactoryBean");
        persion.setAge(1);
        return persion;
    }

    @Override
    public Class<?> getObjectType() {
        return Persion.class;
    }

}
