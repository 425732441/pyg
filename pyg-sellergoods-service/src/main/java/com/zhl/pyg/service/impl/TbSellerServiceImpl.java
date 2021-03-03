package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbSeller;
import com.zhl.pyg.dao.TbSellerDao;
import com.zhl.pyg.service.TbSellerService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbSeller表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:29
 */
@DubboService
public class TbSellerServiceImpl implements TbSellerService {
    @Resource
    private TbSellerDao tbSellerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sellerId 主键
     * @return 实例对象
     */
    @Override
    public TbSeller selectById(String sellerId) {
        return this.tbSellerDao.selectById(sellerId);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbSeller> selectPage(int current, int size) {
        return tbSellerDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbSeller> selectAll() {
        return this.tbSellerDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbSeller> selectList(TbSeller tbSeller) {
        return this.tbSellerDao.selectList(tbSeller);
    }

    /**
     * 新增数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbSeller tbSeller) {
        return this.tbSellerDao.insert(tbSeller);
    }

    /**
     * 批量新增
     *
     * @param tbSellers 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbSeller> tbSellers) {
        return this.tbSellerDao.batchInsert(tbSellers);
    }

    /**
     * 修改数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbSeller update(TbSeller tbSeller) {
        this.tbSellerDao.update(tbSeller);
        return this.selectById(tbSeller.getSellerId());
    }

    /**
     * 通过主键删除数据
     *
     * @param sellerId 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public int deleteById(String sellerId) {
        return this.tbSellerDao.deleteById(sellerId);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbSellerDao.count();
    }
}
