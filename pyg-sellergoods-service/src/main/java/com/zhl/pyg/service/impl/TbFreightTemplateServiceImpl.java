package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbFreightTemplate;
import com.zhl.pyg.dao.TbFreightTemplateDao;
import com.zhl.pyg.service.TbFreightTemplateService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbFreightTemplate表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:24
 */
@DubboService
public class TbFreightTemplateServiceImpl implements TbFreightTemplateService {
    @Resource
    private TbFreightTemplateDao tbFreightTemplateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbFreightTemplate selectById(Long id) {
        return this.tbFreightTemplateDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbFreightTemplate> selectPage(int current, int size) {
        return tbFreightTemplateDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbFreightTemplate> selectAll() {
        return this.tbFreightTemplateDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbFreightTemplate> selectList(TbFreightTemplate tbFreightTemplate) {
        return this.tbFreightTemplateDao.selectList(tbFreightTemplate);
    }

    /**
     * 新增数据
     *
     * @param tbFreightTemplate 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbFreightTemplate tbFreightTemplate) {
        return this.tbFreightTemplateDao.insert(tbFreightTemplate);
    }

    /**
     * 批量新增
     *
     * @param tbFreightTemplates 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbFreightTemplate> tbFreightTemplates) {
        return this.tbFreightTemplateDao.batchInsert(tbFreightTemplates);
    }

    /**
     * 修改数据
     *
     * @param tbFreightTemplate 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbFreightTemplate update(TbFreightTemplate tbFreightTemplate) {
        this.tbFreightTemplateDao.update(tbFreightTemplate);
        return this.selectById(tbFreightTemplate.getId());
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
        return this.tbFreightTemplateDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbFreightTemplateDao.count();
    }
}
