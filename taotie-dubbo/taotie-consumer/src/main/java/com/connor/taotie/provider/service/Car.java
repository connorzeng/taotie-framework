package com.connor.taotie.provider.service;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("dubbo")
public interface Car {


    //根据参数自适应
    //@Adaptive放在方法上,会自动生成一个自适应的类.
    //@Adaptive放在类上,这个类就是自适应类.注入的就是自适应的类.
    @Adaptive("protocol")
    public String getColor(URL url);

    public void getColor();

}
