package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbSpecificationOption;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbSpecificationOption)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:53
 */
@Mapper
public interface TbSpecificationOptionDao extends BaseMapper<TbSpecificationOption> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbSpecificationOption selectById(Long id);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbSpecificationOption> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbSpecificationOption 实例对象
     * @return 对象列表
     */
    List<TbSpecificationOption> selectList(TbSpecificationOption tbSpecificationOption);

    /**
     * 新增数据
     *
     * @param tbSpecificationOption 实例对象
     * @return 影响行数
     */
    int insert(TbSpecificationOption tbSpecificationOption);

    /**
     * 批量新增
     *
     * @param tbSpecificationOptions 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbSpecificationOption> tbSpecificationOptions);

    /**
     * 修改数据
     *
     * @param tbSpecificationOption 实例对象
     * @return 影响行数
     */
    int update(TbSpecificationOption tbSpecificationOption);

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
