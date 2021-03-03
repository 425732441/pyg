package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbItem;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品表(TbItem)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:52
 */
@Mapper
public interface TbItemDao extends BaseMapper<TbItem> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbItem selectById(Long id);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbItem> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbItem 实例对象
     * @return 对象列表
     */
    List<TbItem> selectList(TbItem tbItem);

    /**
     * 新增数据
     *
     * @param tbItem 实例对象
     * @return 影响行数
     */
    int insert(TbItem tbItem);

    /**
     * 批量新增
     *
     * @param tbItems 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbItem> tbItems);

    /**
     * 修改数据
     *
     * @param tbItem 实例对象
     * @return 影响行数
     */
    int update(TbItem tbItem);

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
