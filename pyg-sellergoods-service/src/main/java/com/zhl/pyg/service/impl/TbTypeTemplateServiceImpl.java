package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbTypeTemplate;
import com.zhl.pyg.dao.TbTypeTemplateDao;
import com.zhl.pyg.service.TbTypeTemplateService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbTypeTemplate表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:30
 */
@DubboService
public class TbTypeTemplateServiceImpl implements TbTypeTemplateService {
    @Resource
    private TbTypeTemplateDao tbTypeTemplateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbTypeTemplate selectById(Long id) {
        return this.tbTypeTemplateDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbTypeTemplate> selectPage(int current, int size) {
        return tbTypeTemplateDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbTypeTemplate> selectAll() {
        return this.tbTypeTemplateDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbTypeTemplate> selectList(TbTypeTemplate tbTypeTemplate) {
        return this.tbTypeTemplateDao.selectList(tbTypeTemplate);
    }

    /**
     * 新增数据
     *
     * @param tbTypeTemplate 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbTypeTemplate tbTypeTemplate) {
        return this.tbTypeTemplateDao.insert(tbTypeTemplate);
    }

    /**
     * 批量新增
     *
     * @param tbTypeTemplates 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbTypeTemplate> tbTypeTemplates) {
        return this.tbTypeTemplateDao.batchInsert(tbTypeTemplates);
    }

    /**
     * 修改数据
     *
     * @param tbTypeTemplate 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbTypeTemplate update(TbTypeTemplate tbTypeTemplate) {
        this.tbTypeTemplateDao.update(tbTypeTemplate);
        return this.selectById(tbTypeTemplate.getId());
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
        return this.tbTypeTemplateDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbTypeTemplateDao.count();
    }
}
