package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * (TbSpecificationOption)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:38
 */
@Data
public class TbSpecificationOption implements Serializable {
    private static final long serialVersionUID = 529894996852579420L;
    /**
     * 规格项ID
     */
    private Long id;
    /**
     * 规格项名称
     */
    private String optionName;
    /**
     * 规格ID
     */
    private Long specId;
    /**
     * 排序值
     */
    private Integer orders;
}
