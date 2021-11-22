package com.connor.taotie.mybatis.controller;

import com.connor.taotie.baseservice.dto.RepsponseDTO;
import com.connor.taotie.mybatis.service.NormalService;
import com.connor.taotie.mybatis.service.UserService;
import com.connor.taotie.mybatis.service.impl.NoopServiceImpl;
import com.connor.taotie.mybatis.service.impl.NormalServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AopTestController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private NoopServiceImpl noopServiceImpl;

    @Autowired
    private UserService userService;

    @Autowired
    private NormalService normalService;

    @RequestMapping("/testAop")
    public RepsponseDTO testAop() {
        noopServiceImpl.finalTest();
        log.info("------------------------------------------");
        noopServiceImpl.publicTestNomal();
        log.info("------------------------------------------");
        noopServiceImpl.publicTestSelf();
        log.info("------------------------------------------");
        noopServiceImpl.publicTestSelfCurrentProxy();
        log.info("------------------------------------------");
        return new RepsponseDTO("hello", "hello", "00");
    }


    @RequestMapping("/testAopInterface")
    public RepsponseDTO testAopInterface() {
        normalService.nomalEcho();

        //NormalServiceImp  在JDK代理中是无法获取的
        NormalServiceImp normalServiceImp = (NormalServiceImp) normalService;
        normalServiceImp.nomalEchoNoInterface();
        return new RepsponseDTO("hello", "hello", "00");
    }


    @RequestMapping("/testAop1")
    public RepsponseDTO testAop1() {
        return new RepsponseDTO("hello", "hello", "00");
    }
}
