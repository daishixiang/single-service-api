package com.caict3in.server.demo.service;

import com.caict3in.server.demo.domain.model.UserInfo;
import com.caict3in.server.demo.mapper.UserInfoMapper;
import com.caict3in.server.demo.service.dto.UserDto;
import com.caict3in.server.demo.service.mapstruct.UserConvert;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author daisx
 * @date 2022/9/7
 * @description
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserInfoService {

    private final UserInfoMapper userInfoMapper;

    private final UserConvert userConvert;

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    public UserDto getUserInfo(String userName){
        UserInfo userInfo = userInfoMapper.getUserInfoByUserName(userName);
        return userConvert.convertDto(userInfo);
    }

}
