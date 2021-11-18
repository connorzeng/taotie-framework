package com.connor.taotie.provider.controller;

import com.connor.taotie.baseservice.dto.RepsponseDTO;
import com.connor.taotie.provider.service.MchService;
import com.connor.taotie.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcctController {

    @Autowired
    private UserService userService;

    @Autowired
    private MchService mchService;

    @RequestMapping("/openAcct")
    public RepsponseDTO openAcct() {

        userService.openAcct();
        return new RepsponseDTO("success", "000000", "");
    }

    @RequestMapping("/openMch")
    public RepsponseDTO openMch() {

        mchService.openMch();
        return new RepsponseDTO("success", "000000", "");
    }
}