package com.zhl.pyg.service;

import com.zhl.pyg.entity.TbCities;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 行政区域地州市信息表(TbCities)表服务接口
 *
 * @author protagonist
 * @since 2021-03-03 16:41:23
 */
public interface TbCitiesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbCities selectById(Integer id);

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页数据的条数
     * @return 对象列表
     */
    IPage<TbCities> selectPage(int current, int size);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbCities> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbCities 实例对象
     * @return 对象列表
     */
    List<TbCities> selectList(TbCities tbCities);

    /**
     * 新增数据
     *
     * @param tbCities 实例对象
     * @return 影响行数
     */
    int insert(TbCities tbCities);

    /**
     * 批量新增
     *
     * @param tbCitiess 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbCities> tbCitiess);

    /**
     * 修改数据
     *
     * @param tbCities 实例对象
     * @return 修改
     */
    TbCities update(TbCities tbCities);

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
