package com.zhl.pyg.service;

import com.zhl.pyg.entity.TbUser;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 用户表(TbUser)表服务接口
 *
 * @author protagonist
 * @since 2021-03-03 16:41:30
 */
public interface TbUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUser selectById(Long id);

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页数据的条数
     * @return 对象列表
     */
    IPage<TbUser> selectPage(int current, int size);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<TbUser> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbUser 实例对象
     * @return 对象列表
     */
    List<TbUser> selectList(TbUser tbUser);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int insert(TbUser tbUser);

    /**
     * 批量新增
     *
     * @param tbUsers 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<TbUser> tbUsers);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 修改
     */
    TbUser update(TbUser tbUser);

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
