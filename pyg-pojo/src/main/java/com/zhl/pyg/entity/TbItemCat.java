package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 商品类目(TbItemCat)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:30
 */
@Data
public class TbItemCat implements Serializable {
    private static final long serialVersionUID = 591579789202187146L;
    /**
     * 类目ID
     */
    private Long id;
    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    private Long parentId;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 类型id
     */
    private Long typeId;
}
