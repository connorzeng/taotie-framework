package com.connor.taotieboot.resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


@Component
public class InjectResourceBean implements InitializingBean {

    //ClassPathResource
    @Value("classpath:/mystatic/1.jpeg")
    private Resource imge;



    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("init after");
    }
}
