package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbSeckillGoods;
import com.zhl.pyg.dao.TbSeckillGoodsDao;
import com.zhl.pyg.service.TbSeckillGoodsService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbSeckillGoods表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:28
 */
@DubboService
public class TbSeckillGoodsServiceImpl implements TbSeckillGoodsService {
    @Resource
    private TbSeckillGoodsDao tbSeckillGoodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbSeckillGoods selectById(Long id) {
        return this.tbSeckillGoodsDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbSeckillGoods> selectPage(int current, int size) {
        return tbSeckillGoodsDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbSeckillGoods> selectAll() {
        return this.tbSeckillGoodsDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbSeckillGoods> selectList(TbSeckillGoods tbSeckillGoods) {
        return this.tbSeckillGoodsDao.selectList(tbSeckillGoods);
    }

    /**
     * 新增数据
     *
     * @param tbSeckillGoods 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbSeckillGoods tbSeckillGoods) {
        return this.tbSeckillGoodsDao.insert(tbSeckillGoods);
    }

    /**
     * 批量新增
     *
     * @param tbSeckillGoodss 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbSeckillGoods> tbSeckillGoodss) {
        return this.tbSeckillGoodsDao.batchInsert(tbSeckillGoodss);
    }

    /**
     * 修改数据
     *
     * @param tbSeckillGoods 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbSeckillGoods update(TbSeckillGoods tbSeckillGoods) {
        this.tbSeckillGoodsDao.update(tbSeckillGoods);
        return this.selectById(tbSeckillGoods.getId());
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
        return this.tbSeckillGoodsDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbSeckillGoodsDao.count();
    }
}
