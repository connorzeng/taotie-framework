package com.connor.taotieboot.service.impl;

import com.connor.taotieboot.service.SelfInjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SelfInjectServiceImpl implements SelfInjectService {

    @Autowired
    private SelfInjectService selfInjectService;

    @Override
//    @Async
    public void sayHello() {

    }
}
