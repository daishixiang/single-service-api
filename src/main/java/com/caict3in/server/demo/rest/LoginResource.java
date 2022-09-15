package com.caict3in.server.demo.rest;

import com.caict3in.server.demo.rest.vm.LoginUserVm;
import com.caict3in.server.demo.service.UserInfoService;
import com.caict3in.server.demo.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author daisx
 * @date 2022/9/7
 * @description
 */
@RestController
@RequestMapping("/login")
@Slf4j
@RequiredArgsConstructor
public class LoginResource {

    private final UserInfoService userInfoService;

    @PostMapping("/userName")
    public UserDto getUserInfo(@RequestBody LoginUserVm loginUserVm){

        return UserDto.builder().build();
    }
}
