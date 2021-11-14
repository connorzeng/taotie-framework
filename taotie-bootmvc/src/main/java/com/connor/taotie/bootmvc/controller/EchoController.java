package com.connor.taotie.bootmvc.controller;

import com.connor.taotie.bootmvc.configProperties.ConnorBindConfig;
import com.connor.taotie.bootmvc.dto.ResponseDTO;
import com.connor.taotie.bootmvc.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EchoController {


    @Autowired
    private ApplicationContext applicationContext;


    @Autowired
    private ConnorBindConfig connorBindConfig;


    @ResponseBody//指定ResponseBodyReturnValueHandler
    @RequestMapping("/hello")
    public String hello() {

        return "hello";
    }


    //@FastJsonView
    @ResponseBody
    @RequestMapping("/helloDto")
    public ResponseDTO helloDto() {

        return new ResponseDTO("00000", "success", "hello");
    }



    //@FastJsonView
    @ResponseBody
    @RequestMapping("/helloUser")
    public ResponseDTO helloDto(UserDTO userDTO) {

        //Field error in object 'userDTO' on field 'date': rejected value [2021-01-01]
        //需要initTypeConvert

        return new ResponseDTO("00000", "success", userDTO);
    }


}
