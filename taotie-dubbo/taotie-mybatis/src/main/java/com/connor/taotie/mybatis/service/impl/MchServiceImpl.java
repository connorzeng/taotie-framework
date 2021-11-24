package com.connor.taotie.mybatis.service.impl;

import com.connor.taotie.mybatis.mappper.MchMapper;
import com.connor.taotie.mybatis.mappper.dto.Mch;
import com.connor.taotie.mybatis.service.MchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MchServiceImpl implements MchService {


    @Autowired
    private MchMapper mchMapper;


    @Override
    @Transactional
    public void inserMch() {
        Mch mch = new Mch();
        mch.setId(123);
        mch.setPid("ABC001");
        mch.setPName("第一家商户");
        mch.setPEmail("ganggang334@163.com");
        mchMapper.insert(mch);
    }
}
