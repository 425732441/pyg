package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbAddress;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbAddress)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:51
 */
@Mapper
public interface TbAddressDao extends BaseMapper<TbAddress> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbAddress selectById(Long id);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbAddress> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbAddress 实例对象
     * @return 对象列表
     */
    List<TbAddress> selectList(TbAddress tbAddress);

    /**
     * 新增数据
     *
     * @param tbAddress 实例对象
     * @return 影响行数
     */
    int insert(TbAddress tbAddress);

    /**
     * 批量新增
     *
     * @param tbAddresss 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbAddress> tbAddresss);

    /**
     * 修改数据
     *
     * @param tbAddress 实例对象
     * @return 影响行数
     */
    int update(TbAddress tbAddress);

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
