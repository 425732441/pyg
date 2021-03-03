package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbUser;
import com.zhl.pyg.dao.TbUserDao;
import com.zhl.pyg.service.TbUserService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * 用户表(TbUser表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:31
 */
@DubboService
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserDao tbUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbUser selectById(Long id) {
        return this.tbUserDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbUser> selectPage(int current, int size) {
        return tbUserDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbUser> selectAll() {
        return this.tbUserDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbUser> selectList(TbUser tbUser) {
        return this.tbUserDao.selectList(tbUser);
    }

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbUser tbUser) {
        return this.tbUserDao.insert(tbUser);
    }

    /**
     * 批量新增
     *
     * @param tbUsers 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbUser> tbUsers) {
        return this.tbUserDao.batchInsert(tbUsers);
    }

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbUser update(TbUser tbUser) {
        this.tbUserDao.update(tbUser);
        return this.selectById(tbUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public int deleteById(Long id) {
        return this.tbUserDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbUserDao.count();
    }
}
