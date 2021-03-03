package com.zhl.pyg.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

/**
 * (TbAddress)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:25
 */
@Data
public class TbAddress implements Serializable {
    private static final long serialVersionUID = 661048382974571935L;

    private Long id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 省
     */
    private String provinceId;
    /**
     * 市
     */
    private String cityId;
    /**
     * 县/区
     */
    private String townId;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 是否是默认 1默认 0否
     */
    private String isDefault;
    /**
     * 备注
     */
    private String notes;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 别名
     */
    private String alias;
}
