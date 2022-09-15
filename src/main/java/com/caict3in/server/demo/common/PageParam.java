package com.caict3in.server.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author daisx
 * @date 2022/9/8
 * @description 分页参数
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageParam implements Serializable {
    
    private static final long serialVersionUID = 507594524526546241L;

    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 每页大小
     */
    private int pageSize;
}
