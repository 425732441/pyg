package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbAreas;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 行政区域县区信息表(TbAreas)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:51
 */
@Mapper
public interface TbAreasDao extends BaseMapper<TbAreas> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbAreas selectById(Integer id);

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
     * @return 影响行数
     */
    int update(TbAreas tbAreas);

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
