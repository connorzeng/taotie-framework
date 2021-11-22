package com.connor.taotie.mybatis.service.impl;

import com.connor.taotie.mybatis.service.NormalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class NormalServiceImp implements NormalService {

    @Async
    @Override
    public void nomalEcho() {
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("nomalEcho");
    }


    //如果强制使用JDK代理,这里不会AOP生效
    public void nomalEchoNoInterface() {
        log.info("nomalEchoNoInterface");
    }
}
