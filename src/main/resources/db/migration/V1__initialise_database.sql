-- 用户表
CREATE TABLE user
(
    id              BIGINT(20)          NOT NULL COMMENT '主键ID',
    name            VARCHAR(30)         NOT NULL DEFAULT '' COMMENT '姓名',
    age             INT(11)             NOT NULL DEFAULT 0 COMMENT '年龄',
    email           VARCHAR(50)         NOT NULL DEFAULT '' COMMENT '邮箱',
    create_at       BIGINT(50)          NOT NULL DEFAULT 0 COMMENT '创建时间',
    PRIMARY KEY (id),
    unique key `user_name_unique` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '引导页';