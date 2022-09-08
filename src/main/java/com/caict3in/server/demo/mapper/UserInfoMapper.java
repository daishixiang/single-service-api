package com.caict3in.server.demo.mapper;

import com.caict3in.server.demo.domain.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author daisx
 * @date 2022/9/7
 * @description
 */
public interface UserInfoMapper {

    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return
     */
    UserInfo getUserInfoByUserName(@Param("userName") String userName);

    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> findAll();
}
