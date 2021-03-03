package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbSeckillOrder;
import com.zhl.pyg.dao.TbSeckillOrderDao;
import com.zhl.pyg.service.TbSeckillOrderService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbSeckillOrder表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:28
 */
@DubboService
public class TbSeckillOrderServiceImpl implements TbSeckillOrderService {
    @Resource
    private TbSeckillOrderDao tbSeckillOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbSeckillOrder selectById(Long id) {
        return this.tbSeckillOrderDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbSeckillOrder> selectPage(int current, int size) {
        return tbSeckillOrderDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbSeckillOrder> selectAll() {
        return this.tbSeckillOrderDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbSeckillOrder> selectList(TbSeckillOrder tbSeckillOrder) {
        return this.tbSeckillOrderDao.selectList(tbSeckillOrder);
    }

    /**
     * 新增数据
     *
     * @param tbSeckillOrder 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbSeckillOrder tbSeckillOrder) {
        return this.tbSeckillOrderDao.insert(tbSeckillOrder);
    }

    /**
     * 批量新增
     *
     * @param tbSeckillOrders 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbSeckillOrder> tbSeckillOrders) {
        return this.tbSeckillOrderDao.batchInsert(tbSeckillOrders);
    }

    /**
     * 修改数据
     *
     * @param tbSeckillOrder 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbSeckillOrder update(TbSeckillOrder tbSeckillOrder) {
        this.tbSeckillOrderDao.update(tbSeckillOrder);
        return this.selectById(tbSeckillOrder.getId());
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
        return this.tbSeckillOrderDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbSeckillOrderDao.count();
    }
}
