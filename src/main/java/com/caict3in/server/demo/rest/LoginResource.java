package com.caict3in.server.demo.rest;

import com.caict3in.server.demo.service.UserInfoService;
import com.caict3in.server.demo.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getInfo")
    public UserDto getUserInfo(){

        return UserDto.builder().build();
    }
}
