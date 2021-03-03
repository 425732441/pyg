package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbCities;
import com.zhl.pyg.dao.TbCitiesDao;
import com.zhl.pyg.service.TbCitiesService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * 行政区域地州市信息表(TbCities表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:23
 */
@DubboService
public class TbCitiesServiceImpl implements TbCitiesService {
    @Resource
    private TbCitiesDao tbCitiesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbCities selectById(Integer id) {
        return this.tbCitiesDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbCities> selectPage(int current, int size) {
        return tbCitiesDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbCities> selectAll() {
        return this.tbCitiesDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbCities> selectList(TbCities tbCities) {
        return this.tbCitiesDao.selectList(tbCities);
    }

    /**
     * 新增数据
     *
     * @param tbCities 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbCities tbCities) {
        return this.tbCitiesDao.insert(tbCities);
    }

    /**
     * 批量新增
     *
     * @param tbCitiess 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbCities> tbCitiess) {
        return this.tbCitiesDao.batchInsert(tbCitiess);
    }

    /**
     * 修改数据
     *
     * @param tbCities 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbCities update(TbCities tbCities) {
        this.tbCitiesDao.update(tbCities);
        return this.selectById(tbCities.getId());
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
        return this.tbCitiesDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbCitiesDao.count();
    }
}
