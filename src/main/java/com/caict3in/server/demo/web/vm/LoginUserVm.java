package com.caict3in.server.demo.web.vm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author daisx
 * @date 2022/9/7
 * @description
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserVm {

    /**
     * 登录名
     */
    @NotNull(message = "登录用户名不可为空")
    private String userName;
    /**
     * 密码
     */
    @NotNull(message = "登录密码不可为空")
    private String password;
}
