package com.zhl.pyg.service;

import com.zhl.pyg.entity.TbAreas;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 行政区域县区信息表(TbAreas)表服务接口
 *
 * @author protagonist
 * @since 2021-03-03 16:41:23
 */
public interface TbAreasService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbAreas selectById(Integer id);

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页数据的条数
     * @return 对象列表
     */
    IPage<TbAreas> selectPage(int current, int size);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbAreas> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbAreas 实例对象
     * @return 对象列表
     */
    List<TbAreas> selectList(TbAreas tbAreas);

    /**
     * 新增数据
     *
     * @param tbAreas 实例对象
     * @return 影响行数
     */
    int insert(TbAreas tbAreas);

    /**
     * 批量新增
     *
     * @param tbAreass 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbAreas> tbAreass);

    /**
     * 修改数据
     *
     * @param tbAreas 实例对象
     * @return 修改
     */
    TbAreas update(TbAreas tbAreas);

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
