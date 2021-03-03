package com.zhl.pyg.service;

import com.zhl.pyg.entity.TbPayLog;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * (TbPayLog)表服务接口
 *
 * @author protagonist
 * @since 2021-03-03 16:41:27
 */
public interface TbPayLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param outTradeNo 主键
     * @return 实例对象
     */
    TbPayLog selectById(String outTradeNo);

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页数据的条数
     * @return 对象列表
     */
    IPage<TbPayLog> selectPage(int current, int size);

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
     * @return 修改
     */
    TbPayLog update(TbPayLog tbPayLog);

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
