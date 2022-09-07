package com.caict3in.server.demo.service;

import com.caict3in.server.demo.mapper.UserInfoMapper;
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


}
