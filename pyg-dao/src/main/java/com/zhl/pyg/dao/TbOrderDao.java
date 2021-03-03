package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbOrder;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbOrder)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:52
 */
@Mapper
public interface TbOrderDao extends BaseMapper<TbOrder> {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    TbOrder selectById(Long orderId);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbOrder> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbOrder 实例对象
     * @return 对象列表
     */
    List<TbOrder> selectList(TbOrder tbOrder);

    /**
     * 新增数据
     *
     * @param tbOrder 实例对象
     * @return 影响行数
     */
    int insert(TbOrder tbOrder);

    /**
     * 批量新增
     *
     * @param tbOrders 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbOrder> tbOrders);

    /**
     * 修改数据
     *
     * @param tbOrder 实例对象
     * @return 影响行数
     */
    int update(TbOrder tbOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(Long orderId);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}
