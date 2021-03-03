package com.zhl.pyg.response;

import java.util.Date;

import lombok.Data;

import java.util.List;

/**
 * 分页结果对象
 *
 * @author protagonist
 * @title: PageResult
 * @description: TODO
 * @date 2021-03-03 13:59:40
 */
@Data
public class PageResult<T> {
    private Long total;
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

}
