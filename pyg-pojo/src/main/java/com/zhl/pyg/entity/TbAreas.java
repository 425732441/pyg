package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 行政区域县区信息表(TbAreas)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:25
 */
@Data
public class TbAreas implements Serializable {
    private static final long serialVersionUID = -90066989427672542L;
    /**
     * 唯一ID
     */
    private Integer id;
    /**
     * 区域ID
     */
    private String areaid;
    /**
     * 区域名称
     */
    private String area;
    /**
     * 城市ID
     */
    private String cityid;
}
