package com.caict3in.server.demo.domain.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author daisx
 * @date 2022/9/7
 * @description
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
