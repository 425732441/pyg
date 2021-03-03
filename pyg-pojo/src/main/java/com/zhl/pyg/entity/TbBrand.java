package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * (TbBrand)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:25
 */
@Data
public class TbBrand implements Serializable {
    private static final long serialVersionUID = 634739495317700400L;

    private Long id;
    /**
     * 品牌名称
     */
    private String name;
    /**
     * 品牌首字母
     */
    private String firstChar;
}
