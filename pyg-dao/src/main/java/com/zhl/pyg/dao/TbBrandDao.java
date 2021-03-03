package com.zhl.pyg.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhl.pyg.entity.TbBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (TbBrand)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:51
 */
@Mapper
public interface TbBrandDao extends BaseMapper<TbBrand> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbBrand selectById(Long id);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbBrand> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbBrand 实例对象
     * @return 对象列表
     */
    List<TbBrand> selectList(TbBrand tbBrand);

    /**
     * 新增数据
     *
     * @param tbBrand 实例对象
     * @return 影响行数
     */
    int insert(TbBrand tbBrand);

    /**
     * 批量新增
     *
     * @param tbBrands 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbBrand> tbBrands);

    /**
     * 修改数据
     *
     * @param tbBrand 实例对象
     * @return 影响行数
     */
    int update(TbBrand tbBrand);

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
