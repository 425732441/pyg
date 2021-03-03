package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbItemCat;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品类目(TbItemCat)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:52
 */
@Mapper
public interface TbItemCatDao extends BaseMapper<TbItemCat> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbItemCat selectById(Long id);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbItemCat> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbItemCat 实例对象
     * @return 对象列表
     */
    List<TbItemCat> selectList(TbItemCat tbItemCat);

    /**
     * 新增数据
     *
     * @param tbItemCat 实例对象
     * @return 影响行数
     */
    int insert(TbItemCat tbItemCat);

    /**
     * 批量新增
     *
     * @param tbItemCats 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbItemCat> tbItemCats);

    /**
     * 修改数据
     *
     * @param tbItemCat 实例对象
     * @return 影响行数
     */
    int update(TbItemCat tbItemCat);

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
