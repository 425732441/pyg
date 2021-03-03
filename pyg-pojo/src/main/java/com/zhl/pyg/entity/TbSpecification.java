package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * (TbSpecification)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:37
 */
@Data
public class TbSpecification implements Serializable {
    private static final long serialVersionUID = 140367163229854957L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String specName;
}
