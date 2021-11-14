package com.connor.taotie.bootmvc.configProperties;



import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component//直接读取信息
@ConfigurationProperties(prefix = "connor.bind")
public class ConnorBindConfig {

    private String name;

    private Integer age;

    private List<String> list;

    private Map<String, String> map;
}
