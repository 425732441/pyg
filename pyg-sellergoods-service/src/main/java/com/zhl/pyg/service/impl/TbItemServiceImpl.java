package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbItem;
import com.zhl.pyg.dao.TbItemDao;
import com.zhl.pyg.service.TbItemService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * 商品表(TbItem表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:26
 */
@DubboService
public class TbItemServiceImpl implements TbItemService {
    @Resource
    private TbItemDao tbItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbItem selectById(Long id) {
        return this.tbItemDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbItem> selectPage(int current, int size) {
        return tbItemDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbItem> selectAll() {
        return this.tbItemDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbItem> selectList(TbItem tbItem) {
        return this.tbItemDao.selectList(tbItem);
    }

    /**
     * 新增数据
     *
     * @param tbItem 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbItem tbItem) {
        return this.tbItemDao.insert(tbItem);
    }

    /**
     * 批量新增
     *
     * @param tbItems 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbItem> tbItems) {
        return this.tbItemDao.batchInsert(tbItems);
    }

    /**
     * 修改数据
     *
     * @param tbItem 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbItem update(TbItem tbItem) {
        this.tbItemDao.update(tbItem);
        return this.selectById(tbItem.getId());
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
        return this.tbItemDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbItemDao.count();
    }
}
