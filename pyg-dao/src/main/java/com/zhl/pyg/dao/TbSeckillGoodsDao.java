package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbSeckillGoods;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbSeckillGoods)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:53
 */
@Mapper
public interface TbSeckillGoodsDao extends BaseMapper<TbSeckillGoods> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbSeckillGoods selectById(Long id);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbSeckillGoods> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbSeckillGoods 实例对象
     * @return 对象列表
     */
    List<TbSeckillGoods> selectList(TbSeckillGoods tbSeckillGoods);

    /**
     * 新增数据
     *
     * @param tbSeckillGoods 实例对象
     * @return 影响行数
     */
    int insert(TbSeckillGoods tbSeckillGoods);

    /**
     * 批量新增
     *
     * @param tbSeckillGoodss 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbSeckillGoods> tbSeckillGoodss);

    /**
     * 修改数据
     *
     * @param tbSeckillGoods 实例对象
     * @return 影响行数
     */
    int update(TbSeckillGoods tbSeckillGoods);

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
