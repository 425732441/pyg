package com.zhl.pyg.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

/**
 * 商品表(TbItem)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:30
 */
@Data
public class TbItem implements Serializable {
    private static final long serialVersionUID = -21556305369646519L;
    /**
     * 商品id，同时也是商品编号
     */
    private Long id;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品卖点
     */
    private String sellPoint;
    /**
     * 商品价格，单位为：元
     */
    private Double price;

    private Integer stockCount;
    /**
     * 库存数量
     */
    private Integer num;
    /**
     * 商品条形码
     */
    private String barcode;
    /**
     * 商品图片
     */
    private String image;
    /**
     * 所属类目，叶子类目
     */
    private Long categoryid;
    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    private String itemSn;

    private Double costPirce;

    private Double marketPrice;

    private String isDefault;

    private Long goodsId;

    private String sellerId;

    private String cartThumbnail;

    private String category;

    private String brand;

    private String spec;

    private String seller;
}
