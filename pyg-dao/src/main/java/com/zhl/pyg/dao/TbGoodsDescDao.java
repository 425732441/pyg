package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbGoodsDesc;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbGoodsDesc)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:52
 */
@Mapper
public interface TbGoodsDescDao extends BaseMapper<TbGoodsDesc> {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    TbGoodsDesc selectById(Long goodsId);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbGoodsDesc> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbGoodsDesc 实例对象
     * @return 对象列表
     */
    List<TbGoodsDesc> selectList(TbGoodsDesc tbGoodsDesc);

    /**
     * 新增数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 影响行数
     */
    int insert(TbGoodsDesc tbGoodsDesc);

    /**
     * 批量新增
     *
     * @param tbGoodsDescs 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbGoodsDesc> tbGoodsDescs);

    /**
     * 修改数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 影响行数
     */
    int update(TbGoodsDesc tbGoodsDesc);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 影响行数
     */
    int deleteById(Long goodsId);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}
