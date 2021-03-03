package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbGoods;
import com.zhl.pyg.dao.TbGoodsDao;
import com.zhl.pyg.service.TbGoodsService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbGoods表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:25
 */
@DubboService
public class TbGoodsServiceImpl implements TbGoodsService {
    @Resource
    private TbGoodsDao tbGoodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbGoods selectById(Long id) {
        return this.tbGoodsDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbGoods> selectPage(int current, int size) {
        return tbGoodsDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbGoods> selectAll() {
        return this.tbGoodsDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbGoods> selectList(TbGoods tbGoods) {
        return this.tbGoodsDao.selectList(tbGoods);
    }

    /**
     * 新增数据
     *
     * @param tbGoods 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbGoods tbGoods) {
        return this.tbGoodsDao.insert(tbGoods);
    }

    /**
     * 批量新增
     *
     * @param tbGoodss 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbGoods> tbGoodss) {
        return this.tbGoodsDao.batchInsert(tbGoodss);
    }

    /**
     * 修改数据
     *
     * @param tbGoods 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbGoods update(TbGoods tbGoods) {
        this.tbGoodsDao.update(tbGoods);
        return this.selectById(tbGoods.getId());
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
        return this.tbGoodsDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbGoodsDao.count();
    }
}
