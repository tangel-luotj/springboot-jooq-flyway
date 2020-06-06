-- 用户表
CREATE TABLE `role`
(
    id              BIGINT(20)          NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    user_id         BIGINT(20)          NOT NULL DEFAULT 0 COMMENT '用户ID',
    role_name       VARCHAR(64)         NOT NULL DEFAULT '' COMMENT '角色名称',
    create_at       BIGINT(50)          NOT NULL DEFAULT 0 COMMENT '创建时间',
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '全局配置表';