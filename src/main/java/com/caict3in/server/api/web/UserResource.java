package com.caict3in.server.api.web;

import com.caict3in.server.api.common.PageParam;
import com.caict3in.server.api.common.PageResponse;
import com.caict3in.server.api.service.UserInfoService;
import com.caict3in.server.api.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息
 *
 * @author daisx
 * @apiNote 用户信息相关接口服务
 * @date 2022/9/7
 */
@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserResource {

    private final UserInfoService userInfoService;

    /**
     * 登录用户信息
     *
     * @return
     * @apiNote 获取登录用户信息
     */
    @GetMapping("/getInfo")
    public UserDto getUserInfo() {

        return UserDto.builder().build();
    }


    /**
     * 用户列表
     *
     * @param page 分页参数|com.caict3in.server.demo.common.PageParam
     * @return
     * @apiNote 分页查询所有用户信息列表
     */
    @PostMapping("/findAll")
    public PageResponse<UserDto> findAllUserInfo(@RequestBody PageParam page) {
        return userInfoService.findAllUserInfo(page);
    }


}
