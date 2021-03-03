package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbContentCategory;
import com.zhl.pyg.dao.TbContentCategoryDao;
import com.zhl.pyg.service.TbContentCategoryService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * 内容分类(TbContentCategory表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:24
 */
@DubboService
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Resource
    private TbContentCategoryDao tbContentCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbContentCategory selectById(Long id) {
        return this.tbContentCategoryDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbContentCategory> selectPage(int current, int size) {
        return tbContentCategoryDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbContentCategory> selectAll() {
        return this.tbContentCategoryDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbContentCategory> selectList(TbContentCategory tbContentCategory) {
        return this.tbContentCategoryDao.selectList(tbContentCategory);
    }

    /**
     * 新增数据
     *
     * @param tbContentCategory 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbContentCategory tbContentCategory) {
        return this.tbContentCategoryDao.insert(tbContentCategory);
    }

    /**
     * 批量新增
     *
     * @param tbContentCategorys 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbContentCategory> tbContentCategorys) {
        return this.tbContentCategoryDao.batchInsert(tbContentCategorys);
    }

    /**
     * 修改数据
     *
     * @param tbContentCategory 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbContentCategory update(TbContentCategory tbContentCategory) {
        this.tbContentCategoryDao.update(tbContentCategory);
        return this.selectById(tbContentCategory.getId());
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
        return this.tbContentCategoryDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbContentCategoryDao.count();
    }
}
