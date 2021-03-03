package com.zhl.pyg.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

/**
 * (TbSeckillOrder)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:34
 */
@Data
public class TbSeckillOrder implements Serializable {
    private static final long serialVersionUID = 889021134313159172L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 秒杀商品ID
     */
    private Long seckillId;
    /**
     * 支付金额
     */
    private Double money;
    /**
     * 用户
     */
    private String userId;
    /**
     * 商家
     */
    private String sellerId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 状态
     */
    private String status;
    /**
     * 收货人地址
     */
    private String receiverAddress;
    /**
     * 收货人电话
     */
    private String receiverMobile;
    /**
     * 收货人
     */
    private String receiver;
    /**
     * 交易流水
     */
    private String transactionId;
}
