package com.zhl.pyg.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * (TbContent)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:59:27
 */
@Data
public class TbContent implements Serializable {
    private static final long serialVersionUID = 548212242759129129L;

    private Long id;
    /**
     * 内容类目ID
     */
    private Long categoryId;
    /**
     * 内容标题
     */
    private String title;
    /**
     * 链接
     */
    private String url;
    /**
     * 图片绝对路径
     */
    private String pic;
    /**
     * 状态
     */
    private String status;
    /**
     * 排序
     */
    private Integer sortOrder;
}
