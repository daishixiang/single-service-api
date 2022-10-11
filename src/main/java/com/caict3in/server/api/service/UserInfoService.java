package com.caict3in.server.api.service;

import com.caict3in.server.api.common.PageParam;
import com.caict3in.server.api.common.PageResponse;
import com.caict3in.server.api.domain.model.UserInfo;
import com.caict3in.server.api.mapper.UserInfoMapper;
import com.caict3in.server.api.service.dto.UserDto;
import com.caict3in.server.api.service.mapstruct.UserConvert;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户信息相关服务
 *
 * @author daisx
 * @date 2022/9/7
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserInfoService {

    private final UserInfoMapper userInfoMapper;

    private final UserConvert userConvert;

    /**
     * 根据用户名查询用户信息
     *
     * @param userName
     * @return
     */
    public UserDto getUserInfo(String userName) {
        UserInfo userInfo = userInfoMapper.getUserInfoByUserName(userName);
        return userConvert.convertDto(userInfo);
    }

    /**
     * 分页查询所有用户
     *
     * @param page
     * @return
     */
    public PageResponse<UserDto> findAllUserInfo(PageParam page) {
        Page<UserInfo> userInfos = PageMethod.startPage(page.getPageNum(), page.getPageSize()).doSelectPage(userInfoMapper::findAll);
        return PageResponse.response(userInfos, userConvert::convertDto);
    }
}
