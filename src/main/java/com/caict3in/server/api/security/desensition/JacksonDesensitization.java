package com.caict3in.server.api.security.desensition;


import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 脱敏注解
 *
 * @author daisx
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JsonSerialize(using = JacksonDesensitizeSerializer.class)
@JacksonAnnotationsInside
public @interface JacksonDesensitization {


    /**
     * 脱敏规则类型
     *
     * @return
     */
    JacksonDesensitionType type();

    /**
     * 匹配规则
     *
     * @return
     */
    String match() default "";

    /**
     * 替换规则
     *
     * @return
     */
    String target() default "";

}
