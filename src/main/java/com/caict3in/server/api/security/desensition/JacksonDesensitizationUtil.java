package com.caict3in.server.api.security.desensition;

/**
 * 脱敏工具类
 *
 * @author daisx
 */
public class JacksonDesensitizationUtil {


    /**
     * 脱敏方法
     *
     * @param source
     * @param match
     * @param target
     * @return
     */
    public static String doDesensitization(String source, String match, String target) {
        return source.replaceAll(match, target);
    }

    /**
     * 名称脱敏（默认规则,请慎改）
     * 规则:小于三个字符走默认短姓名规则，大于走默认长姓名规则
     *
     * @param source
     * @return
     */
    public static String desensitizationDefault(String source, JacksonDesensitionType type) {
        return doDesensitization(source, JacksonDesensitionType.from("default_" + type.type).match, JacksonDesensitionType.from("default_" + type.type).target);
    }

    /**
     * 名称脱敏（默认规则,请慎改）
     * 规则:小于三个字符走默认短姓名规则，大于走默认长姓名规则
     *
     * @param source
     * @return
     */
    public static String desensitizationByName(String source) {
        JacksonDesensitionType desensitionType = source.length() > 2 ? JacksonDesensitionType.DEFAULT_LONG_NAME : JacksonDesensitionType.DEFAULT_SHORT_NAME;
        return doDesensitization(source, desensitionType.match, desensitionType.target);
    }

    /**
     * 手机号脱敏（默认规则,请慎改）
     * 规则：默认手机号规则
     *
     * @param source
     * @return
     */
    public static String desensitizationByMobile(String source) {
        return doDesensitization(source, JacksonDesensitionType.DEFAULT_MOBILE.match, JacksonDesensitionType.DEFAULT_MOBILE.target);
    }

    /**
     * 证件号号脱敏（默认规则,请慎改）
     * 规则：18位走默认身份证号规则，其他位走默认卡号规则
     *
     * @param source
     * @return
     */
    public static String desensitizationByIdNo(String source) {
        JacksonDesensitionType desensitionType = source.length() == 18 ? JacksonDesensitionType.DEFAULT_IDENTITY_NO : JacksonDesensitionType.DEFAULT_CARD_NO;
        return doDesensitization(source, desensitionType.match, desensitionType.target);
    }

    /**
     * 脱敏（默认规则,请慎改）
     *
     * @param source
     * @param type
     * @return
     */
    public static String desensitization(String source, JacksonDesensitionType type) {
        String target;
        switch (type) {
            case NAME:
                target = desensitizationByName(source);
                break;
            case ID_NO:
                target = desensitizationByIdNo(source);
                break;
            default:
                target = desensitizationDefault(source, type);
                break;
        }
        return target;
    }

}
