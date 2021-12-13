package com.connor.taotieboot.service.impl;

import com.connor.taotieboot.service.AService;
import com.connor.taotieboot.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


//@Service
public class AServiceImpl implements AService {

    public AServiceImpl(){
        System.out.println("");
    }


    @Autowired
    private BService bService;

    @Async
    @Override
    public void sayAHello() {
        System.out.println("sayAHello");
        //bService.sayBHello();
    }

}
