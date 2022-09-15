package com.caict3in.server.demo.common;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分页数据封装对象
 * @author daisx
 * @param <T>
 */
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PageResponse<T> implements Serializable {

    private static final long serialVersionUID = 4923963969620079138L;
    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 每页大小
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总数量
     */
    private Long total;
    /**
     * 数据集
     */
    private List<T> dataList;


    /**
     * PageInfo<T> -> PageResponse<T>
     * @param pageInfo
     * @param <T>
     * @return
     */
    public static <T> PageResponse<T> response(Page<T> pageInfo){
        PageResponse<T> response = new PageResponse<>();
        response.setPageNum(pageInfo.getPageNum());
        response.setPageSize(pageInfo.getPageSize());
        response.setTotalPage(pageInfo.getPages());
        response.setTotal(pageInfo.getTotal());
        response.setDataList(pageInfo.getResult());
        return response;
    }

    /**
     * PageInfo<T> -> PageResponse<V>
     * @param pageInfo
     * @param function
     * @param <T>
     * @param <V>
     * @return
     */
    public static <T, V> PageResponse<V> response(Page<T> pageInfo, Function<T, V> function) {
        PageResponse<V> response = new PageResponse<>();
        response.setPageNum(pageInfo.getPageNum());
        response.setPageSize(pageInfo.getPageSize());
        response.setTotalPage(pageInfo.getPages());
        response.setTotal(pageInfo.getTotal());
        response.setDataList(pageInfo.getResult().stream().map(function).collect(Collectors.toList()));
        return response;
    }
}
