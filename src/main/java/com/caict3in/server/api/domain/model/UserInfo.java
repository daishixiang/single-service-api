package com.caict3in.server.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 用户模型
 *
 * @author daisx
 * @date 2022/9/7
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo extends BaseModel {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
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
