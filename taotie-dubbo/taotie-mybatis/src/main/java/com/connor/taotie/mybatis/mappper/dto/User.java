package com.connor.taotie.mybatis.mappper.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class User extends BaseDTO {

/*    becif_no                int (20) PRIMARY KEY AUTO_INCREMENT COMMENT '银行客户号',
    name                    VARCHAR(200) COMMENT '用户真实姓名',
    mobile                  VARCHAR(20) COMMENT '用户银行预留手机号',
    email                   VARCHAR(50) COMMENT '用户邮箱',*/
    @TableId
    private Integer becifNo;
    private String name;
    private String mobile;
    private String email;
}
