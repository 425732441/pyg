package com.zhl.pyg.dao;

import com.zhl.pyg.entity.TbPayLog;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbPayLog)表数据库访问层
 *
 * @author protagonist
 * @since 2021-03-03 14:35:53
 */
@Mapper
public interface TbPayLogDao extends BaseMapper<TbPayLog> {

    /**
     * 通过ID查询单条数据
     *
     * @param outTradeNo 主键
     * @return 实例对象
     */
    TbPayLog selectById(String outTradeNo);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbPayLog> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbPayLog 实例对象
     * @return 对象列表
     */
    List<TbPayLog> selectList(TbPayLog tbPayLog);

    /**
     * 新增数据
     *
     * @param tbPayLog 实例对象
     * @return 影响行数
     */
    int insert(TbPayLog tbPayLog);

    /**
     * 批量新增
     *
     * @param tbPayLogs 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbPayLog> tbPayLogs);

    /**
     * 修改数据
     *
     * @param tbPayLog 实例对象
     * @return 影响行数
     */
    int update(TbPayLog tbPayLog);

    /**
     * 通过主键删除数据
     *
     * @param outTradeNo 主键
     * @return 影响行数
     */
    int deleteById(String outTradeNo);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}
