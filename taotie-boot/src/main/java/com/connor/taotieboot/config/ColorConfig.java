package com.connor.taotieboot.config;


import com.connor.taotieboot.dto.Red;
import com.connor.taotieboot.dto.Yellow;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ColorConfig {

    @Bean
    public Yellow yellow(){
        return  new Yellow();
    }


    /**
     * 会有两个Red bean
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Red red(){
        return  new Red();
    }

}
