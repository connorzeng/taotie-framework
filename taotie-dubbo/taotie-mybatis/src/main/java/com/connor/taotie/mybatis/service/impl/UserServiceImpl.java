package com.connor.taotie.mybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.connor.taotie.mybatis.mappper.MchMapper;
import com.connor.taotie.mybatis.mappper.UserMapper;
import com.connor.taotie.mybatis.mappper.dto.User;
import com.connor.taotie.mybatis.mappperBak.UserMapperBak;
import com.connor.taotie.mybatis.service.MchService;
import com.connor.taotie.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private MchMapper mchMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperBak userMapperbak;

    @Autowired
    private MchService mchService;


    @Override
    //@Transactional
    //@Async
    public void doBiz() {

        User user = new User();
        user.setName("曾罡");
        user.setEmail("ganggang@163.com");
        user.setMobile("15815585147");
        userMapper.insert(user);

        try {
            com.connor.taotie.mybatis.mappperBak.dto.User userbak = new com.connor.taotie.mybatis.mappperBak.dto.User();
            userbak.setName("曾罡");
            userbak.setEmail("ganggang@163.com");
            userbak.setMobile("15815585147");
            userMapperbak.insert(userbak);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //mchService.inserMch();
    }

    @Override
    public User doSerarch() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "曾罡");
        User user = userMapper.selectOne(queryWrapper);


        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("name", "曾罡");
        User user2 = userMapper.selectOne(queryWrapper1);


        return user2;

    }


    @Override
    public void echo() {
        log.info("echo-----------");
    }


    //会不会进入代理呢?
    public void echoNoInterface() {
        log.info("echoNoInterface-----------");
    }


    //自调用会不会进入代理呢
    public void echoSelf() {
        echo();
        log.info("echoSelf-----------");
    }
}
