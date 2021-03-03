package com.zhl.pyg.service;

import com.zhl.pyg.entity.TbProvinces;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 省份信息表(TbProvinces)表服务接口
 *
 * @author protagonist
 * @since 2021-03-03 16:41:27
 */
public interface TbProvincesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbProvinces selectById(Integer id);

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页数据的条数
     * @return 对象列表
     */
    IPage<TbProvinces> selectPage(int current, int size);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbProvinces> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbProvinces 实例对象
     * @return 对象列表
     */
    List<TbProvinces> selectList(TbProvinces tbProvinces);

    /**
     * 新增数据
     *
     * @param tbProvinces 实例对象
     * @return 影响行数
     */
    int insert(TbProvinces tbProvinces);

    /**
     * 批量新增
     *
     * @param tbProvincess 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbProvinces> tbProvincess);

    /**
     * 修改数据
     *
     * @param tbProvinces 实例对象
     * @return 修改
     */
    TbProvinces update(TbProvinces tbProvinces);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}
