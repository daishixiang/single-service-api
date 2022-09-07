package com.caict3in.server.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author daisx
 * @date 2022/9/7
 * @description
 */
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 性别（1：男；0：女；-1：未知）
     */
    private String gender;
    /**
     * 头像
     */
    private String profilePicture;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 联系地址
     */
    private String address;
}
