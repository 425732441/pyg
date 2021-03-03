package com.zhl.pyg.service;

import com.zhl.pyg.entity.TbItemCat;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 商品类目(TbItemCat)表服务接口
 *
 * @author protagonist
 * @since 2021-03-03 16:41:26
 */
public interface TbItemCatService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbItemCat selectById(Long id);

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页数据的条数
     * @return 对象列表
     */
    IPage<TbItemCat> selectPage(int current, int size);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbItemCat> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbItemCat 实例对象
     * @return 对象列表
     */
    List<TbItemCat> selectList(TbItemCat tbItemCat);

    /**
     * 新增数据
     *
     * @param tbItemCat 实例对象
     * @return 影响行数
     */
    int insert(TbItemCat tbItemCat);

    /**
     * 批量新增
     *
     * @param tbItemCats 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbItemCat> tbItemCats);

    /**
     * 修改数据
     *
     * @param tbItemCat 实例对象
     * @return 修改
     */
    TbItemCat update(TbItemCat tbItemCat);

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
