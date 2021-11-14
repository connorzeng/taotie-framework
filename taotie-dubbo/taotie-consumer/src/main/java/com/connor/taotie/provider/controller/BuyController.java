package com.connor.taotie.provider.controller;

import com.alibaba.fastjson.JSON;
import com.connor.taotie.baseservice.OrderService;
import com.connor.taotie.baseservice.dto.RepsponseDTO;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyController implements ApplicationContextAware {

    @DubboReference
    private OrderService orderService;

    private ApplicationContext application;

    @Autowired
    private ReferenceConfig referenceConfig;


    @RequestMapping("/buy")
    public String buy() {



        RepsponseDTO repsponseDTO = orderService.echoService();

        return JSON.toJSONString(repsponseDTO);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.application = applicationContext;
    }
}
