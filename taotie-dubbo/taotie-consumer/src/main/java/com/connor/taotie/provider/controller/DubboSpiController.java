package com.connor.taotie.provider.controller;

import com.alibaba.fastjson.JSON;
import com.connor.taotie.baseservice.dto.RepsponseDTO;
import com.connor.taotie.provider.service.Car;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DubboSpiController {

    @RequestMapping("/testSPI")
    public RepsponseDTO testSPI() {

        URL dubboURL = new URL("dubbo","localhost",8080);
        URL httpURL = new URL("http","localhost",8080);


        //创建一个空的MAP
        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);


        Car red = extensionLoader.getExtension("dubbo");
        red.getColor();


        Car adaptiveExtension = extensionLoader.getAdaptiveExtension();
        String color = adaptiveExtension.getColor(dubboURL);
        String color2 = adaptiveExtension.getColor(httpURL);
        log.info("collor dubbo: " + color);
        log.info("collor httpURL: " + color2);


        return  new RepsponseDTO("000","success");
    }
}
