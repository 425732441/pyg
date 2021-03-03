package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbSpecificationOption;
import com.zhl.pyg.dao.TbSpecificationOptionDao;
import com.zhl.pyg.service.TbSpecificationOptionService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbSpecificationOption表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:29
 */
@DubboService
public class TbSpecificationOptionServiceImpl implements TbSpecificationOptionService {
    @Resource
    private TbSpecificationOptionDao tbSpecificationOptionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbSpecificationOption selectById(Long id) {
        return this.tbSpecificationOptionDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbSpecificationOption> selectPage(int current, int size) {
        return tbSpecificationOptionDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbSpecificationOption> selectAll() {
        return this.tbSpecificationOptionDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbSpecificationOption> selectList(TbSpecificationOption tbSpecificationOption) {
        return this.tbSpecificationOptionDao.selectList(tbSpecificationOption);
    }

    /**
     * 新增数据
     *
     * @param tbSpecificationOption 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbSpecificationOption tbSpecificationOption) {
        return this.tbSpecificationOptionDao.insert(tbSpecificationOption);
    }

    /**
     * 批量新增
     *
     * @param tbSpecificationOptions 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbSpecificationOption> tbSpecificationOptions) {
        return this.tbSpecificationOptionDao.batchInsert(tbSpecificationOptions);
    }

    /**
     * 修改数据
     *
     * @param tbSpecificationOption 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbSpecificationOption update(TbSpecificationOption tbSpecificationOption) {
        this.tbSpecificationOptionDao.update(tbSpecificationOption);
        return this.selectById(tbSpecificationOption.getId());
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
        return this.tbSpecificationOptionDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbSpecificationOptionDao.count();
    }
}
