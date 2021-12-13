package com.connor.taotie.provider.service.impl;

import com.connor.taotie.provider.service.Car;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.URL;

@Slf4j
public class RedCar implements Car {
    
    @Override
    public String getColor(URL url) {

        return "dubbo-red";
    }

    @Override
    public void getColor() {
        log.info("redCar getColor");
    }
}
