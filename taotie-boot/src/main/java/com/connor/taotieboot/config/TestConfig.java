package com.connor.taotieboot.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.connor.taotieboot")
public class TestConfig {


//    @Bean
//    CacheManager cacheManager() {
//        return new ConcurrentMapCacheManager();
//    }

}
