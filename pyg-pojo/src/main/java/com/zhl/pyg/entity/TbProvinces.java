package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 省份信息表(TbProvinces)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:33
 */
@Data
public class TbProvinces implements Serializable {
    private static final long serialVersionUID = -90718368127084835L;
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 省份ID
     */
    private String provinceid;
    /**
     * 省份名称
     */
    private String province;
}
