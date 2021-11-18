package com.connor.taotie.provider.service.impl;

import com.connor.taotie.provider.dao.dto.Mch;
import com.connor.taotie.provider.dao.mapper.MchMapper;
import com.connor.taotie.provider.service.MchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MchServiceImpl implements MchService {

    @Autowired
    private MchMapper mchMapper;

    @Override
    public void openMch() {
        Mch mch = new Mch();
        mch.setPid("ABC001");
        mch.setPName("第一家商户");
        mch.setPEmail("ganggang334@163.com");

        mchMapper.insert(mch);
    }
}
