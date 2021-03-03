package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * (TbTypeTemplate)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:38
 */
@Data
public class TbTypeTemplate implements Serializable {
    private static final long serialVersionUID = -16324952473956741L;

    private Long id;
    /**
     * 模板名称
     */
    private String name;
    /**
     * 关联规格
     */
    private String specIds;
    /**
     * 关联品牌
     */
    private String brandIds;
    /**
     * 自定义属性
     */
    private String customAttributeItems;
}
