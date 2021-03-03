package com.zhl.pyg.service;

import com.zhl.pyg.entity.TbOrder;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * (TbOrder)表服务接口
 *
 * @author protagonist
 * @since 2021-03-03 16:41:26
 */
public interface TbOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    TbOrder selectById(Long orderId);

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页数据的条数
     * @return 对象列表
     */
    IPage<TbOrder> selectPage(int current, int size);

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
     * @return 修改
     */
    TbOrder update(TbOrder tbOrder);

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
