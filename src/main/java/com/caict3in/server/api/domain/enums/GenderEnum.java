package com.caict3in.server.api.domain.enums;

/**
 * 性别枚举
 *
 * @author daisx
 * @date 2022/9/7
 */
public enum GenderEnum {

    UNKNOWN("-1", "未知"),

    FEMALE("0", "女"),

    MALE("1", "男");

    String code;
    String description;

    GenderEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
