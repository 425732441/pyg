package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbContent;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbContent)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:51
 */
@Mapper
public interface TbContentDao extends BaseMapper<TbContent> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbContent selectById(Long id);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbContent> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbContent 实例对象
     * @return 对象列表
     */
    List<TbContent> selectList(TbContent tbContent);

    /**
     * 新增数据
     *
     * @param tbContent 实例对象
     * @return 影响行数
     */
    int insert(TbContent tbContent);

    /**
     * 批量新增
     *
     * @param tbContents 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbContent> tbContents);

    /**
     * 修改数据
     *
     * @param tbContent 实例对象
     * @return 影响行数
     */
    int update(TbContent tbContent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}
