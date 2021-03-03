package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 内容分类(TbContentCategory)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:27
 */
@Data
public class TbContentCategory implements Serializable {
    private static final long serialVersionUID = 567634575944702785L;
    /**
     * 类目ID
     */
    private Long id;
    /**
     * 分类名称
     */
    private String name;
}
