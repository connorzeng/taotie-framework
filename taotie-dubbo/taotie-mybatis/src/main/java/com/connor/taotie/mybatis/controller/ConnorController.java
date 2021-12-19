package com.connor.taotie.mybatis.controller;


import com.connor.taotie.baseservice.dto.RepsponseDTO;
import com.connor.taotie.mybatis.mappper.dto.User;
import com.connor.taotie.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConnorController {

    @Autowired
    private UserService userService;

    @RequestMapping("/testInsert")
    public RepsponseDTO testInsert() {
        userService.doBiz();
        return new RepsponseDTO("hello", "hello", "00");
    }

    @RequestMapping("/testQuery")
    public RepsponseDTO testQuery() {
        User user = userService.doSerarch();
        return new RepsponseDTO("hello", "hello", user);
    }
}
