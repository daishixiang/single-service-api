package com.caict3in.server.demo.service.mapstruct;

import com.caict3in.server.demo.domain.model.UserInfo;
import com.caict3in.server.demo.service.dto.UserDto;
import org.mapstruct.Mapper;

/**
 * @author daisx
 * @date 2022/9/8
 * @description
 */
@Mapper(componentModel = "spring")
public interface UserConvert {

    /**
     * 实体转化
     * @param userInfo
     * @return
     */
    UserDto convertDto(UserInfo userInfo);

}
