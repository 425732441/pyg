package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbGoodsDesc;
import com.zhl.pyg.dao.TbGoodsDescDao;
import com.zhl.pyg.service.TbGoodsDescService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbGoodsDesc表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:25
 */
@DubboService
public class TbGoodsDescServiceImpl implements TbGoodsDescService {
    @Resource
    private TbGoodsDescDao tbGoodsDescDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    @Override
    public TbGoodsDesc selectById(Long goodsId) {
        return this.tbGoodsDescDao.selectById(goodsId);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbGoodsDesc> selectPage(int current, int size) {
        return tbGoodsDescDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbGoodsDesc> selectAll() {
        return this.tbGoodsDescDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbGoodsDesc> selectList(TbGoodsDesc tbGoodsDesc) {
        return this.tbGoodsDescDao.selectList(tbGoodsDesc);
    }

    /**
     * 新增数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbGoodsDesc tbGoodsDesc) {
        return this.tbGoodsDescDao.insert(tbGoodsDesc);
    }

    /**
     * 批量新增
     *
     * @param tbGoodsDescs 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbGoodsDesc> tbGoodsDescs) {
        return this.tbGoodsDescDao.batchInsert(tbGoodsDescs);
    }

    /**
     * 修改数据
     *
     * @param tbGoodsDesc 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbGoodsDesc update(TbGoodsDesc tbGoodsDesc) {
        this.tbGoodsDescDao.update(tbGoodsDesc);
        return this.selectById(tbGoodsDesc.getGoodsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public int deleteById(Long goodsId) {
        return this.tbGoodsDescDao.deleteById(goodsId);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbGoodsDescDao.count();
    }
}
