package com.caict3in.server.api.web.vm;

import com.caict3in.server.api.common.PageParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 查询用户
 *
 * @author daisx
 * @date 2022/9/7
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QueryUserVm {

    /**
     * 分页参数
     */
    @NotNull(message = "分页参数不可为空")
    private PageParam page;

    /**
     * 用户姓名
     */
    private String name;
}
