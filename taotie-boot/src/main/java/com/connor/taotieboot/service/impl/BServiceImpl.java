package com.connor.taotieboot.service.impl;

import com.connor.taotieboot.service.AService;
import com.connor.taotieboot.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class BServiceImpl implements BService {

    @Autowired
    private AService aService;

    @Async
    @Override
    public void sayBHello() {
        System.out.println("Bhello");

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
