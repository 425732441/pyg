package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbSeller;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbSeller)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:53
 */
@Mapper
public interface TbSellerDao extends BaseMapper<TbSeller> {

    /**
     * 通过ID查询单条数据
     *
     * @param sellerId 主键
     * @return 实例对象
     */
    TbSeller selectById(String sellerId);

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
     * @return 影响行数
     */
    int update(TbSeller tbSeller);

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
