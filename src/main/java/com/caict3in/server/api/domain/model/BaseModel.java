package com.caict3in.server.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据库基本模型对象
 *
 * @author daisx
 * @date 2022/9/7
 */
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 6593994024759360938L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新人
     */
    private String updatedBy;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
    /**
     * 删除标志（0：未删除；1：已删除）
     */
    private Boolean deleted;

}
