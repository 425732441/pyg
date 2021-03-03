package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbOrder;
import com.zhl.pyg.dao.TbOrderDao;
import com.zhl.pyg.service.TbOrderService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbOrder表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:26
 */
@DubboService
public class TbOrderServiceImpl implements TbOrderService {
    @Resource
    private TbOrderDao tbOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public TbOrder selectById(Long orderId) {
        return this.tbOrderDao.selectById(orderId);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbOrder> selectPage(int current, int size) {
        return tbOrderDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbOrder> selectAll() {
        return this.tbOrderDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbOrder> selectList(TbOrder tbOrder) {
        return this.tbOrderDao.selectList(tbOrder);
    }

    /**
     * 新增数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbOrder tbOrder) {
        return this.tbOrderDao.insert(tbOrder);
    }

    /**
     * 批量新增
     *
     * @param tbOrders 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbOrder> tbOrders) {
        return this.tbOrderDao.batchInsert(tbOrders);
    }

    /**
     * 修改数据
     *
     * @param tbOrder 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbOrder update(TbOrder tbOrder) {
        this.tbOrderDao.update(tbOrder);
        return this.selectById(tbOrder.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public int deleteById(Long orderId) {
        return this.tbOrderDao.deleteById(orderId);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbOrderDao.count();
    }
}
