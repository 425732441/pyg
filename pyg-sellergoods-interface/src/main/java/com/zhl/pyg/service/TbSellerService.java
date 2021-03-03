package com.zhl.pyg.service;

import com.zhl.pyg.entity.TbSeller;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * (TbSeller)表服务接口
 *
 * @author protagonist
 * @since 2021-03-03 16:41:28
 */
public interface TbSellerService {

    /**
     * 通过ID查询单条数据
     *
     * @param sellerId 主键
     * @return 实例对象
     */
    TbSeller selectById(String sellerId);

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页数据的条数
     * @return 对象列表
     */
    IPage<TbSeller> selectPage(int current, int size);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbSeller> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbSeller 实例对象
     * @return 对象列表
     */
    List<TbSeller> selectList(TbSeller tbSeller);

    /**
     * 新增数据
     *
     * @param tbSeller 实例对象
     * @return 影响行数
     */
    int insert(TbSeller tbSeller);

    /**
     * 批量新增
     *
     * @param tbSellers 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbSeller> tbSellers);

    /**
     * 修改数据
     *
     * @param tbSeller 实例对象
     * @return 修改
     */
    TbSeller update(TbSeller tbSeller);

    /**
     * 通过主键删除数据
     *
     * @param sellerId 主键
     * @return 影响行数
     */
    int deleteById(String sellerId);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}
