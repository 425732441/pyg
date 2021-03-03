package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbAreas;
import com.zhl.pyg.dao.TbAreasDao;
import com.zhl.pyg.service.TbAreasService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * 行政区域县区信息表(TbAreas表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:23
 */
@DubboService
public class TbAreasServiceImpl implements TbAreasService {
    @Resource
    private TbAreasDao tbAreasDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbAreas selectById(Integer id) {
        return this.tbAreasDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbAreas> selectPage(int current, int size) {
        return tbAreasDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbAreas> selectAll() {
        return this.tbAreasDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbAreas> selectList(TbAreas tbAreas) {
        return this.tbAreasDao.selectList(tbAreas);
    }

    /**
     * 新增数据
     *
     * @param tbAreas 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbAreas tbAreas) {
        return this.tbAreasDao.insert(tbAreas);
    }

    /**
     * 批量新增
     *
     * @param tbAreass 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbAreas> tbAreass) {
        return this.tbAreasDao.batchInsert(tbAreass);
    }

    /**
     * 修改数据
     *
     * @param tbAreas 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbAreas update(TbAreas tbAreas) {
        this.tbAreasDao.update(tbAreas);
        return this.selectById(tbAreas.getId());
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
        return this.tbAreasDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbAreasDao.count();
    }
}
