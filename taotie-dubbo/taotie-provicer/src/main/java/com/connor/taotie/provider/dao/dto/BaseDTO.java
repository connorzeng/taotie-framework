package com.connor.taotie.provider.dao.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class BaseDTO {
//    created_time            DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
//    updated_time            DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
//    created_by              VARCHAR(100) NOT NULL COMMENT '创建人',
//    updated_by              VARCHAR(100) NOT NULL COMMENT '更新人'
    private Date createTime;
    private Date updatedTime;

    private String createdBy = "sys";
    private String updatedBy = "sys";
}
