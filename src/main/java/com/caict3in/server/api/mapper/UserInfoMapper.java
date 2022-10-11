package com.caict3in.server.api.mapper;

import com.caict3in.server.api.domain.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息Mapper
 *
 * @author daisx
 * @date 2022/9/7
 */
public interface UserInfoMapper {

    /**
     * 根据用户名查询用户信息
     *
     * @param userName 用户名
     * @return
     */
    UserInfo getUserInfoByUserName(@Param("userName") String userName);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<UserInfo> findAll();
}
