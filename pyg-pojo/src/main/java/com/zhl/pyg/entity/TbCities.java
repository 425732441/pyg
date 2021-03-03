package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 行政区域地州市信息表(TbCities)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:26
 */
@Data
public class TbCities implements Serializable {
    private static final long serialVersionUID = -71221022504646696L;
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 城市ID
     */
    private String cityid;
    /**
     * 城市名称
     */
    private String city;
    /**
     * 省份ID
     */
    private String provinceid;
}
