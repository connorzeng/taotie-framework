package com.connor.taotie.provider.controller;

import com.alibaba.fastjson.JSON;
import com.connor.taotie.baseservice.OrderService;
import com.connor.taotie.baseservice.dto.RepsponseDTO;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.service.GenericService;
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

    @Autowired
    private RegistryConfig registryConfig;

    private ApplicationContext application;


    @RequestMapping("/buy")
    public String buy() {
        RepsponseDTO repsponseDTO = orderService.echoService();
        return JSON.toJSONString(repsponseDTO);
    }

    @RequestMapping("/buyGeneric")
    public String buyGeneric() {

        // 引用远程服务
        // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        // 声明为泛化接口
        reference.setGeneric(true);
        // 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口引用
        reference.setInterface("com.connor.taotie.baseservice.OrderService");
        reference.setRegistry(registryConfig);


        GenericService genericService = reference.get();

        try {
            Object genericInvokeResult = genericService.$invoke("echoService", null,
                    null);
            System.out.println(genericInvokeResult);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return JSON.toJSONString("");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.application = applicationContext;
    }


}
