package com.connor.taotie.mybatis.mappper.dto;

import lombok.Data;

@Data
public class Mch extends BaseDTO {

    private Integer id;
    private String pid;
    private String pName;
    private String pEmail;

//    id                      int (20) PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
//    pid                     varchar (20) NOT NULL COMMENT '商户号',
//    p_name                  VARCHAR(100) NOT NULL COMMENT '商户简称',
//    p_email                 VARCHAR(50) COMMENT '商户用户邮箱',
}
