package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbOrderItem;
import com.zhl.pyg.dao.TbOrderItemDao;
import com.zhl.pyg.service.TbOrderItemService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbOrderItem表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:27
 */
@DubboService
public class TbOrderItemServiceImpl implements TbOrderItemService {
    @Resource
    private TbOrderItemDao tbOrderItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbOrderItem selectById(Long id) {
        return this.tbOrderItemDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbOrderItem> selectPage(int current, int size) {
        return tbOrderItemDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbOrderItem> selectAll() {
        return this.tbOrderItemDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbOrderItem> selectList(TbOrderItem tbOrderItem) {
        return this.tbOrderItemDao.selectList(tbOrderItem);
    }

    /**
     * 新增数据
     *
     * @param tbOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbOrderItem tbOrderItem) {
        return this.tbOrderItemDao.insert(tbOrderItem);
    }

    /**
     * 批量新增
     *
     * @param tbOrderItems 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbOrderItem> tbOrderItems) {
        return this.tbOrderItemDao.batchInsert(tbOrderItems);
    }

    /**
     * 修改数据
     *
     * @param tbOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbOrderItem update(TbOrderItem tbOrderItem) {
        this.tbOrderItemDao.update(tbOrderItem);
        return this.selectById(tbOrderItem.getId());
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
        return this.tbOrderItemDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbOrderItemDao.count();
    }
}
