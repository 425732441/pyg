package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbBrand;
import com.zhl.pyg.dao.TbBrandDao;
import com.zhl.pyg.lock.RedisLock;
import com.zhl.pyg.lock.Rlock;
import com.zhl.pyg.service.TbBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * (TbBrand表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:23
 */
@DubboService
public class TbBrandServiceImpl implements TbBrandService {
    @Resource
    private TbBrandDao tbBrandDao;

    @Autowired
    // @Qualifier("redisLock")
            Rlock redisLock;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbBrand selectById(Long id) {

        TbBrand tbBrand = null;
        try {
            redisLock.lock(id + "", UUID.randomUUID().toString(), 10, TimeUnit.SECONDS);
            tbBrand = this.tbBrandDao.selectById(id);
            //业务逻辑
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            redisLock.unlock(id + "");
        }
        return tbBrand;
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbBrand> selectPage(int current, int size) {
        return tbBrandDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbBrand> selectAll() {
        return this.tbBrandDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbBrand> selectList(TbBrand tbBrand) {
        return this.tbBrandDao.selectList(tbBrand);
    }

    /**
     * 新增数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbBrand tbBrand) {
        return this.tbBrandDao.insert(tbBrand);
    }

    /**
     * 批量新增
     *
     * @param tbBrands 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbBrand> tbBrands) {
        return this.tbBrandDao.batchInsert(tbBrands);
    }

    /**
     * 修改数据
     *
     * @param tbBrand 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbBrand update(TbBrand tbBrand) {
        this.tbBrandDao.update(tbBrand);
        return this.selectById(tbBrand.getId());
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
        return this.tbBrandDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbBrandDao.count();
    }
}
