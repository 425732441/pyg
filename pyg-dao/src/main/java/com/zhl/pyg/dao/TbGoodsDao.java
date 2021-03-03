package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbGoods;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbGoods)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:52
 */
@Mapper
public interface TbGoodsDao extends BaseMapper<TbGoods> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbGoods selectById(Long id);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbGoods> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbGoods 实例对象
     * @return 对象列表
     */
    List<TbGoods> selectList(TbGoods tbGoods);

    /**
     * 新增数据
     *
     * @param tbGoods 实例对象
     * @return 影响行数
     */
    int insert(TbGoods tbGoods);

    /**
     * 批量新增
     *
     * @param tbGoodss 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbGoods> tbGoodss);

    /**
     * 修改数据
     *
     * @param tbGoods 实例对象
     * @return 影响行数
     */
    int update(TbGoods tbGoods);

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
