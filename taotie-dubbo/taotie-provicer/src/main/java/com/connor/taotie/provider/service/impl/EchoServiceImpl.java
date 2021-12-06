package com.connor.taotie.provider.service.impl;

import com.connor.taotie.baseservice.OrderService;
import com.connor.taotie.baseservice.dto.RepsponseDTO;
import com.connor.taotie.provider.excetpion.HelloException;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;


@DubboService(cluster = "failfast",loadbalance = "random")//可以配置到接口级别
public class EchoServiceImpl implements OrderService {


    @Override
    public RepsponseDTO echoService() {

        try {
            Thread.sleep(1000);
            throw new HelloException("this is error message","99999","erroe");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RepsponseDTO repsponseDTO = new RepsponseDTO("00000", "success", "hello");
        repsponseDTO.setBaseName("helloBaseName");
        return repsponseDTO;
    }
}
