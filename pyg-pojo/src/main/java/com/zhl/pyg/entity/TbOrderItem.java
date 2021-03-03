package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * (TbOrderItem)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:32
 */
@Data
public class TbOrderItem implements Serializable {
    private static final long serialVersionUID = -15762082796903612L;

    private Long id;
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * SPU_ID
     */
    private Long goodsId;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品单价
     */
    private Double price;
    /**
     * 商品购买数量
     */
    private Integer num;
    /**
     * 商品总金额
     */
    private Double totalFee;
    /**
     * 商品图片地址
     */
    private String picPath;

    private String sellerId;
}
