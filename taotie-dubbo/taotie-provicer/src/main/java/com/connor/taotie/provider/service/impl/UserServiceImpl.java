package com.connor.taotie.provider.service.impl;

import com.connor.taotie.provider.dao.dto.User;
import com.connor.taotie.provider.dao.mapper.UserMapper;
import com.connor.taotie.provider.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DubboService
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public void openAcct() {
        User user = new User();
        user.setName("曾罡");
        user.setEmail("ganggang@163.com");
        user.setMobile("15815585147");
        userMapper.insert(user);
    }
}
