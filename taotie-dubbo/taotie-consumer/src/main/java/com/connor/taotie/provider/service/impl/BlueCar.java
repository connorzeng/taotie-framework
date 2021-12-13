package com.connor.taotie.provider.service.impl;

import com.connor.taotie.provider.service.Car;
import lombok.extern.log4j.Log4j;
import org.apache.dubbo.common.URL;


@Log4j
public class BlueCar implements Car {

    @Override
    public String getColor(URL url) {

        return "http-Blue";
    }

    @Override
    public void getColor() {
        log.info("blueCar getColor");
    }
}
