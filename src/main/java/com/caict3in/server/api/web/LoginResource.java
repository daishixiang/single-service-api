package com.caict3in.server.api.web;

import com.caict3in.server.api.service.UserInfoService;
import com.caict3in.server.api.service.dto.UserDto;
import com.caict3in.server.api.web.vm.LoginUserVm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 *
 * @author daisx
 * @apiNote 登录相关接口服务
 * @date 2022/9/7
 */
@RestController
@RequestMapping("/login")
@Slf4j
@RequiredArgsConstructor
public class LoginResource {

    private final UserInfoService userInfoService;

    /**
     * 用户名登录
     *
     * @param loginUserVm 登录参数|com.caict3in.server.demo.web.vm.LoginUserVm
     * @return
     * @apiNote 用户名+密码
     */
    @PostMapping("/userName")
    public UserDto getUserInfo(@RequestBody LoginUserVm loginUserVm) {

        return UserDto.builder().build();
    }
}
