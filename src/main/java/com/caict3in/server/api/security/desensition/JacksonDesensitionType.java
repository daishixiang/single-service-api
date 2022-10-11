package com.caict3in.server.api.security.desensition;

import cn.hutool.core.util.ObjectUtil;

/**
 * 数据脱敏类型
 * 新增类型时（需要添加 type 和 default_type(必须有匹配规则和替换规则)）
 *
 * @author daisx
 */
public enum JacksonDesensitionType {

    MOBILE("mobile", "手机号码"),

    NAME("name", "名称"),

    ID_NO("id_no", "证件号码"),

    IDENTITY_NO("identity_no", "身份证号（默认身份证号规则）"),

    CARD_NO("card_no", "卡号（默认卡号规则）"),


    /**
     * 以下类型为默认规则
     */
    DEFAULT_MOBILE("default_mobile", "手机号（默认规则）", "\\d{0,7}(\\w{4})", "*******$1"),

    DEFAULT_IDENTITY_NO("default_identity_no", "身份证号（默认规则）", "\\d{0,14}(\\w{4})", "**************$1"),

    DEFAULT_CARD_NO("default_card_no", "卡号（默认规则）", "\\d+(\\w{4})", "****$1"),

    DEFAULT_SHORT_NAME("default_name1", "短姓名（默认规则）", "[\\w\\u4e00-\\u9fa5_.[ ]]+([\\w\\u4e00-\\u9fa5]{1})", "*$1"),

    DEFAULT_LONG_NAME("default_name2", "长姓名（默认规则）", "[\\w\\u4e00-\\u9fa5_.[ ]]+([\\w\\u4e00-\\u9fa5]{1})", "**$1"),

    DEFAULT("default", "缺省值", "", "");

    /**
     * 类型
     */
    String type;

    /**
     * 说明
     */
    String describe;

    /**
     * 匹配规则
     */
    String match;

    /**
     * 替换规则
     */
    String target;

    JacksonDesensitionType(String type, String describe) {
        this.type = type;
        this.describe = describe;
    }

    JacksonDesensitionType(String type, String describe, String match, String target) {
        this.type = type;
        this.describe = describe;
        this.match = match;
        this.target = target;
    }

    public static JacksonDesensitionType from(String type) {
        for (JacksonDesensitionType value : values()) {
            if (ObjectUtil.equal(value.type, type)) {
                return value;
            }
        }
        return DEFAULT;
    }
}
