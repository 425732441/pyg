package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * (TbGoodsDesc)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:29
 */
@Data
public class TbGoodsDesc implements Serializable {
    private static final long serialVersionUID = -42674902372609570L;
    /**
     * SPU_ID
     */
    private Long goodsId;
    /**
     * 描述
     */
    private String introduction;
    /**
     * 规格结果集，所有规格，包含isSelected
     */
    private String specificationItems;
    /**
     * 自定义属性（参数结果）
     */
    private String customAttributeItems;

    private String itemImages;
    /**
     * 包装列表
     */
    private String packageList;
    /**
     * 售后服务
     */
    private String saleService;
}
