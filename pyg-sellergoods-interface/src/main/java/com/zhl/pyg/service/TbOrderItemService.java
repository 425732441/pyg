package com.zhl.pyg.service;

import com.zhl.pyg.entity.TbOrderItem;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * (TbOrderItem)表服务接口
 *
 * @author protagonist
 * @since 2021-03-03 16:41:27
 */
public interface TbOrderItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbOrderItem selectById(Long id);

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页数据的条数
     * @return 对象列表
     */
    IPage<TbOrderItem> selectPage(int current, int size);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbOrderItem> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbOrderItem 实例对象
     * @return 对象列表
     */
    List<TbOrderItem> selectList(TbOrderItem tbOrderItem);

    /**
     * 新增数据
     *
     * @param tbOrderItem 实例对象
     * @return 影响行数
     */
    int insert(TbOrderItem tbOrderItem);

    /**
     * 批量新增
     *
     * @param tbOrderItems 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbOrderItem> tbOrderItems);

    /**
     * 修改数据
     *
     * @param tbOrderItem 实例对象
     * @return 修改
     */
    TbOrderItem update(TbOrderItem tbOrderItem);

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
