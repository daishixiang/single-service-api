package com.caict3in.server.api.service.mapstruct;

import com.caict3in.server.api.domain.model.UserInfo;
import com.caict3in.server.api.service.dto.UserDto;
import org.mapstruct.Mapper;

/**
 * 用户实体转化器
 *
 * @author daisx
 * @date 2022/9/8
 */
@Mapper(componentModel = "spring")
public interface UserConvert {

    /**
     * 实体转化
     *
     * @param userInfo
     * @return
     */
    UserDto convertDto(UserInfo userInfo);

}
