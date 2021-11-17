-- 创建4个分库
create database `shardingdb0` default character set utf8 collate utf8_general_ci;
create database `shardingdb1` default character set utf8 collate utf8_general_ci;
create database `shardingdb2` default character set utf8 collate utf8_general_ci;
create database `shardingdb3` default character set utf8 collate utf8_general_ci;

-- 创建表用户
create user shardinguser0 identified by '1234';
grant all on shardingdb0.* to shardinguser0@'%' identified by '1234' with grant option;
create user shardinguser1 identified by '1234';
grant all on shardingdb1.* to shardinguser1@'%' identified by '1234' with grant option;
create user shardinguser2 identified by '1234';
grant all on shardingdb2.* to shardinguser2@'%' identified by '1234' with grant option;
create user shardinguser3 identified by '1234';
grant all on shardingdb3.* to shardinguser3@'%' identified by '1234' with grant option;



-- 基础用户表,不进行分表
-- 开户五项信息:
CREATE TABLE users
(
    becif_no                int (20) PRIMARY KEY AUTO_INCREMENT COMMENT '银行客户号',
    name                    VARCHAR(200) COMMENT '用户真实姓名',
    mobile                  VARCHAR(20) COMMENT '用户银行预留手机号',
    email                   VARCHAR(50) COMMENT '用户邮箱',
    created_time            DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    updated_time            DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    created_by              VARCHAR(100) NOT NULL COMMENT '创建人',
    updated_by              VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT '用户表';
CREATE UNIQUE INDEX ux_users_username
    ON users (name);
CREATE UNIQUE INDEX ux_users_mobile
    ON users (mobile);
CREATE UNIQUE INDEX ux_users_becif
    ON users (becif_no);



-- 创建商户表-PID分表
CREATE TABLE mch
(
    id                      int (20) PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    pid                     varchar (20) NOT NULL COMMENT '商户号',
    p_name                  VARCHAR(100) NOT NULL COMMENT '商户简称',
    p_email                 VARCHAR(50) COMMENT '商户用户邮箱',
    created_time            DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    updated_time            DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    created_by              VARCHAR(100) NOT NULL COMMENT '创建人',
    updated_by              VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT '商户表';
CREATE UNIQUE INDEX ux_mch_pid
    ON mch (pid);
CREATE UNIQUE INDEX ux_mch_pname
    ON mch (p_name);


-- 渠道鉴权表-PID分表
CREATE TABLE mch_user_auth
(
    id                      int (20) PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    pid                     varchar (20) NOT NULL  COMMENT '商户号',
    third_id                varchar (20) NOT NULL  COMMENT '商户会员号',
    becif_no                int (20) NOT NULL  COMMENT '银行客户号',
    name                    VARCHAR(200) COMMENT '用户真实姓名',
    mobile                  VARCHAR(20) COMMENT '用户银行预留手机号',
    email                   VARCHAR(50) COMMENT '用户邮箱',
    created_time            DATETIME     NOT NULL DEFAULT now() COMMENT '创建时间',
    updated_time            DATETIME     NOT NULL DEFAULT now() COMMENT '更新时间',
    created_by              VARCHAR(100) NOT NULL COMMENT '创建人',
    updated_by              VARCHAR(100) NOT NULL COMMENT '更新人'
) COMMENT '渠道鉴权表';
CREATE UNIQUE INDEX ux_pid_third_id
    ON mch_user_auth (pid,third_id);
CREATE INDEX u_pid_becif
    ON mch_user_auth (pid,becif_no);






