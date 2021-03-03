package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbAddress;
import com.zhl.pyg.dao.TbAddressDao;
import com.zhl.pyg.service.TbAddressService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbAddress表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:22
 */
@DubboService
public class TbAddressServiceImpl implements TbAddressService {
    @Resource
    private TbAddressDao tbAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbAddress selectById(Long id) {
        return this.tbAddressDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbAddress> selectPage(int current, int size) {
        return tbAddressDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbAddress> selectAll() {
        return this.tbAddressDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbAddress> selectList(TbAddress tbAddress) {
        return this.tbAddressDao.selectList(tbAddress);
    }

    /**
     * 新增数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbAddress tbAddress) {
        return this.tbAddressDao.insert(tbAddress);
    }

    /**
     * 批量新增
     *
     * @param tbAddresss 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbAddress> tbAddresss) {
        return this.tbAddressDao.batchInsert(tbAddresss);
    }

    /**
     * 修改数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbAddress update(TbAddress tbAddress) {
        this.tbAddressDao.update(tbAddress);
        return this.selectById(tbAddress.getId());
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
        return this.tbAddressDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbAddressDao.count();
    }
}
