package com.zhl.pyg.service.impl;

import com.zhl.pyg.entity.TbPayLog;
import com.zhl.pyg.dao.TbPayLogDao;
import com.zhl.pyg.service.TbPayLogService;
import org.springframework.transaction.annotation.Transactional;
import org.apache.dubbo.config.annotation.DubboService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;
import java.util.List;


/**
 * (TbPayLog表)服务实现类
 *
 * @author protagonist
 * @since 2021-03-03 16:41:27
 */
@DubboService
public class TbPayLogServiceImpl implements TbPayLogService {
    @Resource
    private TbPayLogDao tbPayLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param outTradeNo 主键
     * @return 实例对象
     */
    @Override
    public TbPayLog selectById(String outTradeNo) {
        return this.tbPayLogDao.selectById(outTradeNo);
    }

    /**
     * 分页查询
     *
     * @param current 当前页
     * @param size    每一页的条数
     * @return 对象列表
     */
    @Override
    public IPage<TbPayLog> selectPage(int current, int size) {
        return tbPayLogDao.selectPage(new Page(current, size), new QueryWrapper<>());
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbPayLog> selectAll() {
        return this.tbPayLogDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<TbPayLog> selectList(TbPayLog tbPayLog) {
        return this.tbPayLogDao.selectList(tbPayLog);
    }

    /**
     * 新增数据
     *
     * @param tbPayLog 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public int insert(TbPayLog tbPayLog) {
        return this.tbPayLogDao.insert(tbPayLog);
    }

    /**
     * 批量新增
     *
     * @param tbPayLogs 实例对象的集合
     * @return 生效的条数
     */
    @Override
    @Transactional
    public int batchInsert(List<TbPayLog> tbPayLogs) {
        return this.tbPayLogDao.batchInsert(tbPayLogs);
    }

    /**
     * 修改数据
     *
     * @param tbPayLog 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbPayLog update(TbPayLog tbPayLog) {
        this.tbPayLogDao.update(tbPayLog);
        return this.selectById(tbPayLog.getOutTradeNo());
    }

    /**
     * 通过主键删除数据
     *
     * @param outTradeNo 主键
     * @return 是否成功
     */
    @Override
    @Transactional
    public int deleteById(String outTradeNo) {
        return this.tbPayLogDao.deleteById(outTradeNo);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.tbPayLogDao.count();
    }
}
