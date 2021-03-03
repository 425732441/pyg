package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbProvinces;
import com.zhl.pyg.dao.TbProvincesDao;
import com.zhl.pyg.service.TbProvincesService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * 省份信息表(TbProvinces表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:27
 */
@DubboService
public class TbProvincesServiceImpl implements TbProvincesService {
    @Resource
    private TbProvincesDao tbProvincesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbProvinces selectById(Integer id) {
        return this.tbProvincesDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbProvinces> selectPage(int current, int size) {
        return tbProvincesDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbProvinces> selectAll() {
        return this.tbProvincesDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbProvinces> selectList(TbProvinces tbProvinces) {
        return this.tbProvincesDao.selectList(tbProvinces);
    }

    /**
     * 新增数据
     *
     * @param tbProvinces 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbProvinces tbProvinces) {
        return this.tbProvincesDao.insert(tbProvinces);
    }

    /**
     * 批量新增
     *
     * @param tbProvincess 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbProvinces> tbProvincess) {
        return this.tbProvincesDao.batchInsert(tbProvincess);
    }

    /**
     * 修改数据
     *
     * @param tbProvinces 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbProvinces update(TbProvinces tbProvinces) {
        this.tbProvincesDao.update(tbProvinces);
        return this.selectById(tbProvinces.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public int deleteById(Integer id) {
        return this.tbProvincesDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbProvincesDao.count();
    }
}
