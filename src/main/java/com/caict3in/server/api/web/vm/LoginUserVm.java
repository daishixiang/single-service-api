package com.caict3in.server.api.web.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 用户名登录参数
 *
 * @author daisx
 * @date 2022/9/7
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserVm {

    /**
     * 登录名
     *
     * @mock admin
     */
    @NotNull(message = "登录用户名不可为空")
    private String userName;
    /**
     * 密码
     *
     * @mock 123456
     */
    @NotNull(message = "登录密码不可为空")
    private String password;
}
