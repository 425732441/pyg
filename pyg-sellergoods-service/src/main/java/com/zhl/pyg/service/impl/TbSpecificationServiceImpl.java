package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbSpecification;
import com.zhl.pyg.dao.TbSpecificationDao;
import com.zhl.pyg.service.TbSpecificationService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbSpecification表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:29
 */
@DubboService
public class TbSpecificationServiceImpl implements TbSpecificationService {
    @Resource
    private TbSpecificationDao tbSpecificationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbSpecification selectById(Long id) {
        return this.tbSpecificationDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbSpecification> selectPage(int current, int size) {
        return tbSpecificationDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbSpecification> selectAll() {
        return this.tbSpecificationDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbSpecification> selectList(TbSpecification tbSpecification) {
        return this.tbSpecificationDao.selectList(tbSpecification);
    }

    /**
     * 新增数据
     *
     * @param tbSpecification 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbSpecification tbSpecification) {
        return this.tbSpecificationDao.insert(tbSpecification);
    }

    /**
     * 批量新增
     *
     * @param tbSpecifications 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbSpecification> tbSpecifications) {
        return this.tbSpecificationDao.batchInsert(tbSpecifications);
    }

    /**
     * 修改数据
     *
     * @param tbSpecification 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbSpecification update(TbSpecification tbSpecification) {
        this.tbSpecificationDao.update(tbSpecification);
        return this.selectById(tbSpecification.getId());
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
        return this.tbSpecificationDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbSpecificationDao.count();
    }
}
