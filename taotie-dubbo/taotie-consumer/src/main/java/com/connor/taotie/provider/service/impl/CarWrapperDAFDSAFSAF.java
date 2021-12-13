package com.connor.taotie.provider.service.impl;

import com.connor.taotie.provider.service.Car;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;

@Slf4j
public class CarWrapperDAFDSAFSAF implements Car {

    private Car car;

    //
    public CarWrapperDAFDSAFSAF(Car car) {
        this.car = car;
    }

    @Override
    public String getColor(URL url) {

        log.info("CarWrapper - before");
        String color = car.getColor(url);
        log.info("CarWrapper - after");

        return color;
    }

    @Override
    public void getColor() {
        log.info("CarWrapper - before");
        car.getColor();
        log.info("CarWrapper - after");
    }
}
