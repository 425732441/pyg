package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbItemCat;
import com.zhl.pyg.dao.TbItemCatDao;
import com.zhl.pyg.service.TbItemCatService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * 商品类目(TbItemCat表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:26
 */
@DubboService
public class TbItemCatServiceImpl implements TbItemCatService {
    @Resource
    private TbItemCatDao tbItemCatDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbItemCat selectById(Long id) {
        return this.tbItemCatDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbItemCat> selectPage(int current, int size) {
        return tbItemCatDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbItemCat> selectAll() {
        return this.tbItemCatDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbItemCat> selectList(TbItemCat tbItemCat) {
        return this.tbItemCatDao.selectList(tbItemCat);
    }

    /**
     * 新增数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbItemCat tbItemCat) {
        return this.tbItemCatDao.insert(tbItemCat);
    }

    /**
     * 批量新增
     *
     * @param tbItemCats 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbItemCat> tbItemCats) {
        return this.tbItemCatDao.batchInsert(tbItemCats);
    }

    /**
     * 修改数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbItemCat update(TbItemCat tbItemCat) {
        this.tbItemCatDao.update(tbItemCat);
        return this.selectById(tbItemCat.getId());
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
        return this.tbItemCatDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbItemCatDao.count();
    }
}
