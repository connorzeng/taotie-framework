package com.connor.taotie.mybatis.service.impl;

import com.connor.taotie.mybatis.mappper.MchMapper;
import com.connor.taotie.mybatis.mappper.UserMapper;
import com.connor.taotie.mybatis.mappper.dto.Mch;
import com.connor.taotie.mybatis.mappper.dto.User;
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

    @Override
    @Transactional
    @Async
    public void doBiz() {

        Mch mch = new Mch();
        mch.setId(123);
        mch.setPid("ABC001");
        mch.setPName("第一家商户");
        mch.setPEmail("ganggang334@163.com");

        mchMapper.insert(mch);


        User user = new User();
        user.setName("曾罡");
        user.setEmail("ganggang@163.com");
        user.setMobile("15815585147");
        userMapper.insert(user);

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
