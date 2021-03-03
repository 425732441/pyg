package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbContent;
import com.zhl.pyg.dao.TbContentDao;
import com.zhl.pyg.service.TbContentService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbContent表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:24
 */
@DubboService
public class TbContentServiceImpl implements TbContentService {
    @Resource
    private TbContentDao tbContentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbContent selectById(Long id) {
        return this.tbContentDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbContent> selectPage(int current, int size) {
        return tbContentDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbContent> selectAll() {
        return this.tbContentDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbContent> selectList(TbContent tbContent) {
        return this.tbContentDao.selectList(tbContent);
    }

    /**
     * 新增数据
     *
     * @param tbContent 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbContent tbContent) {
        return this.tbContentDao.insert(tbContent);
    }

    /**
     * 批量新增
     *
     * @param tbContents 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbContent> tbContents) {
        return this.tbContentDao.batchInsert(tbContents);
    }

    /**
     * 修改数据
     *
     * @param tbContent 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbContent update(TbContent tbContent) {
        this.tbContentDao.update(tbContent);
        return this.selectById(tbContent.getId());
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
        return this.tbContentDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbContentDao.count();
    }
}
