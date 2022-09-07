CREATE TABLE `user_info`
(
    `id`              BIGINT(19)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `created_by`      VARCHAR(64)  NULL     DEFAULT NULL COMMENT '创建人' COLLATE 'utf8mb4_0900_ai_ci',
    `created_at`      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_by`      VARCHAR(64)  NULL     DEFAULT NULL COMMENT '更新人' COLLATE 'utf8mb4_0900_ai_ci',
    `updated_at`      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`         BIT(1)       NOT NULL DEFAULT 'b\'0\'' COMMENT '删除标志（0：未删除；1：已删除）',
    `user_name`       VARCHAR(64)  NOT NULL COMMENT '用户名' COLLATE 'utf8mb4_0900_ai_ci',
    `password`        VARCHAR(255) NOT NULL COMMENT '密码' COLLATE 'utf8mb4_0900_ai_ci',
    `nick_name`       VARCHAR(128) NULL     DEFAULT NULL COMMENT '用户昵称' COLLATE 'utf8mb4_0900_ai_ci',
    `gender`          CHAR(2)      NULL     DEFAULT '-1' COMMENT '性别（1：男；0：女；-1：未知）' COLLATE 'utf8mb4_0900_ai_ci',
    `profile_picture` VARCHAR(255) NULL     DEFAULT NULL COMMENT '头像' COLLATE 'utf8mb4_0900_ai_ci',
    `real_name`       VARCHAR(128) NULL     DEFAULT NULL COMMENT '真实姓名' COLLATE 'utf8mb4_0900_ai_ci',
    `mobile`          VARCHAR(32)  NULL     DEFAULT NULL COMMENT '联系电话' COLLATE 'utf8mb4_0900_ai_ci',
    `address`         VARCHAR(255) NULL     DEFAULT NULL COMMENT '联系地址' COLLATE 'utf8mb4_0900_ai_ci',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `user_name` (`user_name`) USING BTREE
)
    COMMENT ='用户信息'
    COLLATE = 'utf8mb4_0900_ai_ci'
    ENGINE = InnoDB
;
