package com.caict3in.server.demo.rest;

import com.caict3in.server.demo.common.PageParam;
import com.caict3in.server.demo.common.PageResponse;
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
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserResource {

    private final UserInfoService userInfoService;

    @GetMapping("/getInfo")
    public UserDto getUserInfo(){

        return UserDto.builder().build();
    }


    @PostMapping("/findAll")
    public PageResponse<UserDto> findAllUserInfo(@RequestBody PageParam page){
        return userInfoService.findAllUserInfo(page);
    }


}
